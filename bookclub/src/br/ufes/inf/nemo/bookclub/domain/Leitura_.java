package br.ufes.inf.nemo.bookclub.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Leitura.class)
public class Leitura_ extends PersistentObjectSupport_ {

//	private Book livro;
	public static volatile SingularAttribute<Leitura, Book>  livro;

//	private Usuario usuario;
	public static volatile SingularAttribute<Leitura, Usuario>  usuario;
	
//	private String situacao; 
	public static volatile SingularAttribute<Leitura, String>  situacao;
	
//	private Boolean gostei;	
	public static volatile SingularAttribute<Leitura, Boolean>  gostei;
	
//	private String resenha;
	public static volatile SingularAttribute<Leitura, String>  resenha;
	
	
}