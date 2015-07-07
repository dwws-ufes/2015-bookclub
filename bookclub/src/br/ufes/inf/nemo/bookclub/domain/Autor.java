package br.ufes.inf.nemo.bookclub.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Autor extends PersistentObjectSupport  implements Comparable<Autor>, Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(nullable = false, unique = true)
//	private Long id;
	
	String nome;
	
	String sobrenome;
	
	@Temporal(TemporalType.DATE)
	Date dataNascimento;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="autor")
//	Set<Book> livros;

	@Override
	public int compareTo(Autor o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

//	public Set<Book> getLivros() {
//		return livros;
//	}
//
//	public void setLivros(Set<Book> livros) {
//		this.livros = livros;
//	}
	
	
	

}
