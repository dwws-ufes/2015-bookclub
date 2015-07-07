package br.ufes.inf.nemo.bookclub.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.bookclub.domain.Usuario;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface UsuarioDAO extends BaseDAO<Usuario> {

}
