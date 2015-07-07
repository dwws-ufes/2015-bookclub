package br.ufes.inf.nemo.bookclub.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import br.ufes.inf.nemo.bookclub.domain.Usuario;
import br.ufes.inf.nemo.bookclub.persistence.UsuarioDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
@TransactionAttribute
public class ManageUsuariosServiceBean extends CrudServiceBean<Usuario> implements
		ManageUsuariosService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB private UsuarioDAO usuariosDAO;
	
	@Override
	public BaseDAO<Usuario> getDAO() {
		return usuariosDAO;
	}

	@Override
	protected Usuario createNewEntity() {
		return new Usuario();
	}

}
