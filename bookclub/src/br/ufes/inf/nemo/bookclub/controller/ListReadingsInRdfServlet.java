package br.ufes.inf.nemo.bookclub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.vocabulary.RDF;

import br.ufes.inf.nemo.bookclub.domain.Leitura;
import br.ufes.inf.nemo.bookclub.persistence.LeituraDAO;

@WebServlet(urlPatterns = { "/data/readings" })
public class ListReadingsInRdfServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private LeituraDAO leituraDAO;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
	ServletException, IOException {
		resp.setContentType("text/xml");

		List<Leitura> leituras = leituraDAO.retrieveAll();

		Model model = ModelFactory.createDefaultModel();
		String myNS = "http://localhost:8080/bookclub/data/readings";
		String dsNS = "http://purl.org/goodrelations/v1#";
		model.setNsPrefix("ds", dsNS);
		Resource dsLeitura = ResourceFactory.createResource(dsNS + "Leitura");
		Property livro = ResourceFactory.createProperty(dsNS + "Book");
		Property usuario = ResourceFactory.createProperty(dsNS + "Usuario");
		Property situacao = ResourceFactory.createProperty(dsNS + "Situacao");

		for (Leitura l : leituras) {
			Resource LeiturasResourceRDF = model.createResource(myNS + l.getId());

			LeiturasResourceRDF.addProperty(RDF.type, dsLeitura);
			LeiturasResourceRDF.addLiteral(livro, l.getLivro().getTitulo());
			LeiturasResourceRDF.addLiteral(usuario, l.getUsuario().getNome());
			LeiturasResourceRDF.addLiteral(situacao, l.getSituacao());
		}

		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
}
