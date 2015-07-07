package br.ufes.inf.nemo.bookclub.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.bookclub.domain.Book;
import br.ufes.inf.nemo.bookclub.persistence.BookDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageBooksServiceBean extends CrudServiceBean<Book> implements
		ManageBooksService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB private BookDAO booksDAO;
	
	@Override
	public BaseDAO<Book> getDAO() {
		return booksDAO;
	}

	@Override
	protected Book createNewEntity() {
		return new Book();
	}

}
