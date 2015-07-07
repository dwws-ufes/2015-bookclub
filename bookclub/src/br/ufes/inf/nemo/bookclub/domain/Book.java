package br.ufes.inf.nemo.bookclub.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;





import javax.validation.constraints.Size;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Book extends PersistentObjectSupport implements Comparable<Book> {

	// private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(nullable = false, unique = true)
//	private Long id;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="livro")
	private Set<Leitura> leituras;
	
	// private String identificador;
	private String titulo;
	
	
	private String autor;
	// private String autorKey;
	// private Boolean fonteGutenberg;
	private String editora;
	@Size(max = 50000000)
	private String sinopse;

	@Temporal(TemporalType.DATE)
	private Date dataPublicacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	private Long numPaginas;


	public Set<Leitura> getLeituras() {
		return leituras;
	}

	public void setLeituras(Set<Leitura> leituras) {
		this.leituras = leituras;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Long getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Long numPaginas) {
		this.numPaginas = numPaginas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int compareTo(Book arg0) {
		// TODO Auto-generated method stub
//		if (titulo == arg0.titulo) {
//
//			if (dataPublicacao.after(arg0.dataPublicacao))
//				return -1;
//			if (dataPublicacao.before(arg0.dataPublicacao))
//				return 1;
//			return 0;
//		}
		
		return titulo.compareTo(arg0.titulo);
		
		
	}
	
	@Override
	public String toString() {
		return titulo; 
	}

}
