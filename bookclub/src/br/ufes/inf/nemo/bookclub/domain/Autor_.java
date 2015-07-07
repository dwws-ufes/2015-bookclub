package br.ufes.inf.nemo.bookclub.domain;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Autor.class)
public class Autor_ extends PersistentObjectSupport_ {
	
	
//	String nome;
	public static volatile SingularAttribute<Autor, String>  nome;
	
//	String ;
	public static volatile SingularAttribute<Autor, String>  sobrenome;
	
	
//	 ;
	public static volatile SingularAttribute<Autor, Date>  dataNascimento;
	
	
//	Set<Book> livros;
	public static volatile SetAttribute<Autor, Book> livros;
}
