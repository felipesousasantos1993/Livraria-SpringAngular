/*package br.com.livraria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb003_locacao")
public class Locacao implements Serializable {

	private static final long serialVersionUID = -7656707998210747931L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nu_locacao", nullable = false)
	private Long nuLocacao;

	@Column(name = "dt_inicio_locacao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtInicioLocacao;

	@Column(name = "dt_fim_locacao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtFimLocacao;

}
*/