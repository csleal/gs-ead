package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "t_gco_portaria")
@SequenceGenerator(name = "portaria", sequenceName = "SQ_T_GCO_PORTARIA", allocationSize = 1)
public class Portaria implements Serializable {
	
	private static final long serialVersionUID = 4761672436538668090L;

	public Portaria() {
		
	}
	
	public Portaria(int numero, String nome, String status, LocalDate dataInicio, LocalDate dataTermino, Condominio condominio) {
		this.numero = numero;
		this.nome = nome;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.condominio = condominio;
	}
	
	@Id
	@Column(name="id_portaria")
	@GeneratedValue(generator = "portaria", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="nr_portaria", nullable = false)
	private int numero;
	
	@Column(name="nm_portaria", length = 20, nullable = false)
	private String nome;
	
	@Column(name="st_status", length = 10, nullable = false)
	private String status;
	
	@Column(name="dt_inicio", nullable = false)
	private LocalDate dataInicio;
	
	@Column(name="dt_termino", nullable = false)
	private LocalDate dataTermino;
	
	@ManyToOne
	@JoinColumn(name = "id_condominio")
	private Condominio condominio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	
	@Override
	public String toString() {
		return "\nNumero da Portaria: " + this.getNumero()
		+"\nNome da Portaria: " + this.getNome()
		+"\nStatus: " + this.getStatus()
		+"\nData Início: " + this.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		+"\nData Termino: " + this.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		+"\nCondominio: " +this.getCondominio().getNomeFantasia();
	}

}
