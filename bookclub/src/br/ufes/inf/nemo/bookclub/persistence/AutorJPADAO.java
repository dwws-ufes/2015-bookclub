package br.ufes.inf.nemo.bookclub.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.bookclub.domain.Autor;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class AutorJPADAO extends BaseJPADAO<Autor> implements AutorDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Class<Autor> getDomainClass() {
		// TODO Auto-generated method stub
		return Autor.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
