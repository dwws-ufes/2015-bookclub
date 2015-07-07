package br.ufes.inf.nemo.bookclub.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.bookclub.domain.Leitura;
import br.ufes.inf.nemo.bookclub.persistence.LeituraDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageLeiturasServiceBean extends CrudServiceBean<Leitura> implements
		ManageLeiturasService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB private LeituraDAO leituraDAO;
	
	@Override
	public BaseDAO<Leitura> getDAO() {
		return leituraDAO;
	}

	@Override
	protected Leitura createNewEntity() {
		return new Leitura();
	}

}
