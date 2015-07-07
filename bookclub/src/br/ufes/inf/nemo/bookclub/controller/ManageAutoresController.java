package br.ufes.inf.nemo.bookclub.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.bookclub.application.ManageAutoresService;
import br.ufes.inf.nemo.bookclub.domain.Autor;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;


@Named @SessionScoped
public class ManageAutoresController extends CrudController<Autor> {

	@EJB private ManageAutoresService manageAutoresService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManageAutoresController() {
	    viewPath = "/manageAutores/";
	    bundleName = "msgs";
	}
	
	
	@Override
	protected Autor createNewEntity() {
		return new Autor();
	}

	@Override
	protected CrudService<Autor> getCrudService() {
		return manageAutoresService;
	}

	@Override
	protected void initFilters() {
		addFilter(new SimpleFilter("manageAutores.filter.byNome", "nome", getI18nMessage("msgs", "manageAutores.text.filter.byNome")));
	}

}
