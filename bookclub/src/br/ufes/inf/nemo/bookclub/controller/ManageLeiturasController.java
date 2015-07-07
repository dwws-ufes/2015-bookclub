package br.ufes.inf.nemo.bookclub.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.ufes.inf.nemo.bookclub.application.ManageBooksService;
import br.ufes.inf.nemo.bookclub.application.ManageLeiturasService;
import br.ufes.inf.nemo.bookclub.application.ManageUsuariosService;
import br.ufes.inf.nemo.bookclub.domain.Book;
import br.ufes.inf.nemo.bookclub.domain.Leitura;
import br.ufes.inf.nemo.bookclub.domain.Usuario;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Startup
@ManagedBean
@Named 
@SessionScoped
public class ManageLeiturasController extends CrudController<Leitura> {

	@EJB 
	private ManageLeiturasService manageLeiturasService;
	@EJB 
	private ManageUsuariosService manageusuarioService;
	@EJB 
	private ManageBooksService managebookService;


	private List<Usuario> listausuarios;
	private List<Book> listalivro;
	private Long idusuario;
	private Long idlivro;
	private String situacao;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@PostConstruct
	void inicializar(){
		listausuarios = manageusuarioService.getDAO().retrieveAll();
		listalivro = managebookService.getDAO().retrieveAll();
	}

	public String salvarleitura() throws IOException{
		Leitura leitura = new Leitura();
		Usuario usuario = manageusuarioService.getDAO().retrieveById(idusuario);
		Book book = managebookService.getDAO().retrieveById(idlivro);
		leitura.setUsuario(usuario);
		leitura.setLivro(book);
		leitura.setSituacao(situacao);
		manageLeiturasService.getDAO().save(leitura);
		//FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		//context.redirect("/inicio.xhtml");
		RequestContext.getCurrentInstance().update("listingForm:listing");
		externalContext.redirect(externalContext.getRequestContextPath()+"/manageLeituras/list.faces");
		return list();
	}

	public ManageLeiturasController() {
		viewPath = "/manageLeituras/";
		bundleName = "msgs";
		listausuarios = new ArrayList<Usuario>();
	}


	@Override
	protected Leitura createNewEntity() {
		return new Leitura();
	}

	@Override
	protected CrudService<Leitura> getCrudService() {
		return manageLeiturasService;
	}

	@Override
	protected void initFilters() {
		addFilter(new SimpleFilter("manageLeituras.filter.byLivro", "livro", getI18nMessage("msgs", "manageLeituras.text.filter.byLivro")));
	}

	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	public List<Usuario> getListausuarios() {
		return listausuarios;
	}


	public void setListausuarios(List<Usuario> listausuarios) {
		this.listausuarios = listausuarios;
	}


	public List<Book> getListalivro() {
		return listalivro;
	}


	public void setListalivro(List<Book> listalivro) {
		this.listalivro = listalivro;
	}


	public Long getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}


	public Long getIdlivro() {
		return idlivro;
	}


	public void setIdlivro(Long idlivro) {
		this.idlivro = idlivro;
	}
}
