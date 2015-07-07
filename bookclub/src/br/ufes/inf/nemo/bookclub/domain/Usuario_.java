package br.ufes.inf.nemo.bookclub.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Usuario.class)
public class Usuario_ extends PersistentObjectSupport_ {
	
//	private String nome;
	public static volatile SingularAttribute<Usuario, String>  nome;

	
//	private String sobre;
	public static volatile SingularAttribute<Usuario, String>  sobre;

	
//	private String login;
	public static volatile SingularAttribute<Usuario, String>  login;

	
//	private String password;
	public static volatile SingularAttribute<Usuario, String>  password;
	
	//private Set<Leitura> leituras;
	public static volatile SetAttribute<Usuario, Leitura> leituras;
	

}