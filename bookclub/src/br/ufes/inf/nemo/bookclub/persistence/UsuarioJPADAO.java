package br.ufes.inf.nemo.bookclub.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.bookclub.domain.Usuario;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class UsuarioJPADAO extends BaseJPADAO<Usuario> implements UsuarioDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Class<Usuario> getDomainClass() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
