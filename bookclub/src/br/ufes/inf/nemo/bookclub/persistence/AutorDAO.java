package br.ufes.inf.nemo.bookclub.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.bookclub.domain.Autor;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface AutorDAO extends BaseDAO<Autor> {

}
