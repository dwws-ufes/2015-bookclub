package br.ufes.inf.nemo.bookclub.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.bookclub.domain.Book;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class BookJPADAO extends BaseJPADAO<Book> implements BookDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Class<Book> getDomainClass() {
		// TODO Auto-generated method stub
		return Book.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
