package br.ufes.inf.nemo.bookclub.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;

import br.ufes.inf.nemo.bookclub.application.ManageBooksService;
import br.ufes.inf.nemo.bookclub.domain.Book;
import br.ufes.inf.nemo.bookclub.persistence.BookDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;


@Named @SessionScoped
public class ManageBooksController extends CrudController<Book> {
	
	private Book book= new Book();

	@EJB private ManageBooksService manageBooksService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManageBooksController() {
	    viewPath = "/manageBooks/";
	    bundleName = "msgs";
	}
	
	@EJB
	private BookDAO bookDAO;
	
	private List<Book> books;
	
	@Inject
	void loadBooks(){
		books = bookDAO.retrieveAll();
	}
	
	public List<Book> getBooks(){
		return books;
	}
	
	public String add(){
		//bookDAO.save(book);
		save();
		books.add(book);
		book = new Book();
		
		return list();
	}
	
	@Override
	protected Book createNewEntity() {
		return new Book();
	}

	@Override
	protected CrudService<Book> getCrudService() {
		return manageBooksService;
	}

	@Override
	protected void initFilters() {
		addFilter(new SimpleFilter("manageBooks.filter.byTitulo", "titulo", getI18nMessage("msgs", "manageBooks.text.filter.byTitulo")));
	}
	
	public Book getBook(){
		return book;
	}
	
	public void setData(){
		String name = selectedEntity.getTitulo();
		
		if (name != null && name.length() > 3) {
			String query = "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +
					"PREFIX dbpprop: <http://dbpedia.org/property/> " +
					"SELECT ?desc ?author " +
					"WHERE { " +
						"?book a dbpedia-owl:Book ; " +
						"dbpprop:name ?name ; " +
						"dbpprop:author ?author ; " +
						"dbpedia-owl:abstract ?desc . " +
						"FILTER (lcase(str(?name)) = \"" + name.toLowerCase() + "\") " +
						"FILTER (langMatches(lang(?desc), \"EN\")) " +
					"}";
			
			QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
			ResultSet results = queryExecution.execSelect();
			
			if (results.hasNext()) {
				QuerySolution querySolution = results.next();
				Literal sinopse = querySolution.getLiteral("desc");
						
				String s = "" + sinopse.getValue();
				s=s.substring(0, 49);
				selectedEntity.setSinopse(s);
				Resource author = querySolution.getResource("author");
				String a = "" + author.getLocalName();
				a = a.replaceAll("_", " ");
				
				selectedEntity.setAutor(a);
			}
		}
	}

}
