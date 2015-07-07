package br.ufes.inf.nemo.bookclub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;


@Entity
public class Leitura extends PersistentObjectSupport  implements Comparable<Leitura> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(nullable = false, unique = true)
//	private Long id;
	
	@ManyToOne
	private Book livro;

	@ManyToOne
	private Usuario usuario;
	
	private String situacao ;
	
	private String description ;
	
	private Boolean gostei;	
	
	@Column(columnDefinition="TEXT")
	private String resenha;
	
	
	
	@Override
	public int compareTo(Leitura o) {
		// TODO Auto-generated method stub
		return 0;
	}



	public Boolean getGostei() {
		return gostei;
	}



	public void setGostei(Boolean gostei) {
		this.gostei = gostei;
	}



	public Book getLivro() {
		return livro;
	}



	public void setLivro(Book livro) {
		this.livro = livro;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getDescription() {
		return "Descricao da leitura...";
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSituacao() {
		return situacao;
	}



	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}



	public Boolean getFavorita() {
		return gostei;
	}



	public void setFavorita(Boolean favorita) {
		this.gostei = favorita;
	}



	public String getResenha() {
		return resenha;
	}



	public void setResenha(String resenha) {
		this.resenha = resenha;
	}
	
	
	

}
