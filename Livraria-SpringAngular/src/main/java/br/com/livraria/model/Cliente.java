package br.com.livraria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb002_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1999839042536482299L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nu_cliente")
	private Long nuCliente;

	@Column(name = "no_cliente", length = 150, nullable = false)
	private String noCliente;

	@Column(name = "nu_cpf", length = 11, nullable = false)
	private String nuCpf;

	@Column(name = "dt_nascimento", nullable = false)
	private Date dtNascimento;

	@Column(name = "de_logradouro", length = 250, nullable = true)
	private String deLogradouro;

	@Column(name = "nu_logradouro", length = 10, nullable = true)
	private String nuLogradouro;

	@Column(name = "de_bairro", length = 100, nullable = true)
	private String deBairro;

	@Column(name = "de_cidade", length = 100, nullable = true)
	private String deCidade;

	@Column(name = "sg_uf", length = 2, nullable = true)
	private String sgUf;

	@Column(name = "nu_cep", length = 8, nullable = true)
	private String nuCep;

	@Column(name = "nu_telefone", length = 10, nullable = true)
	private String nuTelefone;

	@Column(name = "nu_celular", length = 11, nullable = true)
	private String nuCelular;

	public Long getNuCliente() {
		return nuCliente;
	}

	public void setNuCliente(Long nuCliente) {
		this.nuCliente = nuCliente;
	}

	public String getNoCliente() {
		return noCliente;
	}

	public void setNoCliente(String noCliente) {
		this.noCliente = noCliente;
	}

	public String getNuCpf() {
		return nuCpf;
	}

	public void setNuCpf(String nuCpf) {
		this.nuCpf = nuCpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getDeLogradouro() {
		return deLogradouro;
	}

	public void setDeLogradouro(String deLogradouro) {
		this.deLogradouro = deLogradouro;
	}

	public String getNuLogradouro() {
		return nuLogradouro;
	}

	public void setNuLogradouro(String nuLogradouro) {
		this.nuLogradouro = nuLogradouro;
	}

	public String getNuCep() {
		return nuCep;
	}

	public void setNuCep(String nuCep) {
		this.nuCep = nuCep;
	}

	public String getNuTelefone() {
		return nuTelefone;
	}

	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}

	public String getNuCelular() {
		return nuCelular;
	}

	public void setNuCelular(String nuCelular) {
		this.nuCelular = nuCelular;
	}

	public String getDeBairro() {
		return deBairro;
	}

	public void setDeBairro(String deBairro) {
		this.deBairro = deBairro;
	}

	public String getDeCidade() {
		return deCidade;
	}

	public void setDeCidade(String deCidade) {
		this.deCidade = deCidade;
	}

	public String getSgUf() {
		return sgUf;
	}

	public void setSgUf(String sgUf) {
		this.sgUf = sgUf;
	}

}
