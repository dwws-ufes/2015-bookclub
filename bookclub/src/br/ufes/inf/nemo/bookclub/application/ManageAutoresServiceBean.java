package br.ufes.inf.nemo.bookclub.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.bookclub.domain.Autor;
import br.ufes.inf.nemo.bookclub.persistence.AutorDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageAutoresServiceBean extends CrudServiceBean<Autor> implements
		ManageAutoresService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB private AutorDAO autoresDAO;
	
	@Override
	public BaseDAO<Autor> getDAO() {
		return autoresDAO;
	}

	@Override
	protected Autor createNewEntity() {
		return new Autor();
	}

}
