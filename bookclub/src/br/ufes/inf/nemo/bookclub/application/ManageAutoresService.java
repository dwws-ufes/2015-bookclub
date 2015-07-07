package br.ufes.inf.nemo.bookclub.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.bookclub.domain.Autor;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageAutoresService extends CrudService<Autor> {

}
