package br.ufes.inf.nemo.bookclub.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.bookclub.domain.Usuario;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageUsuariosService extends CrudService<Usuario> {

}
