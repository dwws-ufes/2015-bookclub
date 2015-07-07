package br.ufes.inf.nemo.bookclub.domain;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Book.class)
public class Book_ extends PersistentObjectSupport_ {
	
	
	//private Set<Leitura> leituras;
	public static volatile SetAttribute<Book, Leitura> leituras;
		
	//private String titulo;
	public static volatile SingularAttribute<Book, String>  titulo;
	
	//private String autor;
	public static volatile SingularAttribute<Book, String>  autor;
	
	//private String editora;
	public static volatile SingularAttribute<Book, String>  editora;
	
	//private String sinopse;
	public static volatile SingularAttribute<Book, String>  sinopse;
	
	//private Date dataPublicacao;
	public static volatile SingularAttribute<Book, Date>  dataPublicacao;

	//private Date dataCadastro;
	public static volatile SingularAttribute<Book, Date>  dataCadastro;
	
	//private Long numPaginas;
	public static volatile SingularAttribute<Book, Long>  numPaginas;
}
