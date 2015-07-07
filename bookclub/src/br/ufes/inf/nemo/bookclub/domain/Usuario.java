package br.ufes.inf.nemo.bookclub.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Usuario extends PersistentObjectSupport  implements Comparable<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	private String nome;

	@Column(columnDefinition="TEXT")
	private String sobre;

	private String login;
	
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="usuario")
	private Set<Leitura> leituras =  new HashSet<Leitura>();



	public Set<Leitura> getLeituras() {
		return leituras;
	}

	public void setLeituras(Set<Leitura> leituras) {
		this.leituras = leituras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
