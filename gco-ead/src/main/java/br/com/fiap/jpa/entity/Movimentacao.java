package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_movimentacao_portaria")
@SequenceGenerator(name = "movimentacao", sequenceName = "SQ_T_GCO_MOVIMENTACAO_PORTARIA", allocationSize = 1)
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = -7573343557348018351L;

	public Movimentacao() {
		
	}
	
	public Movimentacao(String tipoMovimentacao, LocalDateTime dataMovimentacao, Portaria portaria, FuncionarioPortaria funcionario, Visitante visitante) {
		this.tipoMovimentacao = tipoMovimentacao;
		this.dataMovimentacao = dataMovimentacao;
		this.portaria = portaria;
		this.funcionario = funcionario;
		this.visitante = visitante;
	}
	
	@Id
	@Column(name="id_movimentacao")
	@GeneratedValue(generator = "movimentacao", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="tp_movimentacao", length = 1, nullable = false)
	private String tipoMovimentacao;
	
	@Column(name="dt_movimentacao", nullable = false)
	private LocalDateTime dataMovimentacao;

	@ManyToOne
	@JoinColumn(name = "id_portaria")
	private Portaria portaria;
	
	@ManyToOne
	@JoinColumn(name = "id_func_portaria")
	private FuncionarioPortaria funcionario;
	
	@ManyToOne
	@JoinColumn(name = "id_visitante")
	private Visitante visitante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Portaria getPortaria() {
		return portaria;
	}

	public void setPortaria(Portaria portaria) {
		this.portaria = portaria;
	}

	public FuncionarioPortaria getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioPortaria funcionario) {
		this.funcionario = funcionario;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
	
	@Override
	public String toString() {
		return "\nTipo: " + this.getTipoMovimentacao()
		+"\nPortaria: " + this.getPortaria().getNome()
		+"\nFuncionário: " + this.getFuncionario().getNome()
		+"\nVisitante: " + this.getVisitante().getNome()
		+"\nData: " + this.getDataMovimentacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
	
}
