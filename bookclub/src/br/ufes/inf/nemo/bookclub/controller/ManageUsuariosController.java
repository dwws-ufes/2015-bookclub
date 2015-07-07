package br.ufes.inf.nemo.bookclub.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.bookclub.application.ManageUsuariosService;
import br.ufes.inf.nemo.bookclub.domain.Usuario;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;


@Named @SessionScoped
public class ManageUsuariosController extends CrudController<Usuario> {

	@EJB private ManageUsuariosService manageUsuariosService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManageUsuariosController() {
	    viewPath = "/manageUsuarios/";
	    bundleName = "msgs";
	}
	
	
	@Override
	protected Usuario createNewEntity() {
		return new Usuario();
	}

	@Override
	protected CrudService<Usuario> getCrudService() {
		return manageUsuariosService;
	}

	@Override
	protected void initFilters() {
		addFilter(new SimpleFilter("manageUsuarios.filter.byNome", "nome", getI18nMessage("msgs", "manageUsuarios.text.filter.byNome")));
	}

}
