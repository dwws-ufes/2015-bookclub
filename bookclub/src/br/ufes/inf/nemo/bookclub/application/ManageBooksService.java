package br.ufes.inf.nemo.bookclub.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.bookclub.domain.Book;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageBooksService extends CrudService<Book> {

}
