package br.ufes.inf.nemo.bookclub.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.bookclub.domain.Leitura;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class LeituraJPADAO extends BaseJPADAO<Leitura> implements LeituraDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Class<Leitura> getDomainClass() {
		// TODO Auto-generated method stub
		return Leitura.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
