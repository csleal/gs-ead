package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_condominio")
@SequenceGenerator(name = "condominio", sequenceName = "SQ_T_GCO_CONDOMINIO", allocationSize = 1)
public class Condominio implements Serializable {
	
	private static final long serialVersionUID = 6161682307519883329L;
	
	public Condominio() {
		
	}
	
	public Condominio(String cnpj, String razaoSocial, String nomeFantasia, LocalDate dataFundacao) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataFundacao = dataFundacao;
	}

	@Id
	@Column(name="id_condominio")
	@GeneratedValue(generator = "condominio", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="nr_cnpj", length = 11, nullable = false)
	private String cnpj;
	
	@Column(name="ds_razao_social", length = 20, nullable = false)
	private String razaoSocial;
	
	@Column(name="nm_fantasia",  length = 20, nullable = false)
	private String nomeFantasia;
	
	@Column(name="dt_fundacao", nullable = false)
	private LocalDate dataFundacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	@Override
	public String toString() {
		return "\nCondominio: " + this.getCnpj()
			+"\nRazão Social: " + this.getRazaoSocial()
			+"\nNome Fantasia: " + this.getNomeFantasia()
			+"\nData Fundanção: " + this.getDataFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
