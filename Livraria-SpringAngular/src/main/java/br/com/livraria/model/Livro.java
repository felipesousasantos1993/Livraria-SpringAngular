package br.com.livraria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb001_livro")
public class Livro implements Serializable {

	private static final long serialVersionUID = 6176554780363568239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nu_livro")
	private Integer nuLivro;

	@Column(name = "de_titulo")
	private String deTitulo;

	@Column(name = "aa_publicacao")
	private Integer aaPublicacao;

	@Column(name = "de_autor")
	private String deAutor;

	@Column(name = "de_editora")
	private String deEditora;

	@Column(name = "de_edicao")
	private String deEdicao;

	@Column(name = "ic_ativo", length = 1)
	private Boolean ativo;

	public Integer getNuLivro() {
		return nuLivro;
	}

	public void setNuLivro(Integer nuLivro) {
		this.nuLivro = nuLivro;
	}

	public String getDeTitulo() {
		return deTitulo;
	}

	public void setDeTitulo(String deTitulo) {
		this.deTitulo = deTitulo;
	}

	public Integer getAaPublicacao() {
		return aaPublicacao;
	}

	public void setAaPublicacao(Integer aaPublicacao) {
		this.aaPublicacao = aaPublicacao;
	}

	public String getDeAutor() {
		return deAutor;
	}

	public void setDeAutor(String deAutor) {
		this.deAutor = deAutor;
	}

	public String getDeEditora() {
		return deEditora;
	}

	public void setDeEditora(String deEditora) {
		this.deEditora = deEditora;
	}

	public String getDeEdicao() {
		return deEdicao;
	}

	public void setDeEdicao(String deEdicao) {
		this.deEdicao = deEdicao;
	}

	public Boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
