package br.ufes.inf.nemo.bookclub.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.bookclub.domain.Leitura;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface LeituraDAO extends BaseDAO<Leitura> {

}
