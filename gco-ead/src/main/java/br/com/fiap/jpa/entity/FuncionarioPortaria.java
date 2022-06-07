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
@Table(name = "t_gco_func_portaria")
@SequenceGenerator(name = "funcionarioPortaria", sequenceName = "SQ_T_GCO_FUNC_PORTARIA", allocationSize = 1)
public class FuncionarioPortaria implements Serializable {

	private static final long serialVersionUID = 6008420529921358293L;

	public FuncionarioPortaria() {
		
	}
	
	public FuncionarioPortaria(String nome, LocalDate nascimento, String cpf, String rg, LocalDate cadastro ) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.cadastro = cadastro;
	}
	
	@Id
	@Column(name="id_func_portaria")
	@GeneratedValue(generator = "funcionarioPortaria", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="nm_funcionario", length = 60 ,nullable = false)
	private String nome;
	
	@Column(name="dt_nasc", nullable = false)
	private LocalDate nascimento;
	
	@Column(name="nr_cpf", length = 14, nullable = false)
	private String cpf;
	
	@Column(name="nr_rg", length = 12, nullable = false)
	private String rg;
	
	@Column(name="dt_cadastro", nullable = false)
	private LocalDate cadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getCadastro() {
		return cadastro;
	}

	public void setCadastro(LocalDate cadastro) {
		this.cadastro = cadastro;
	}
	
	@Override
	public String toString() {
		return "\nNome Funcionário: " + this.getNome()
		+"\nData de Nascimento: " + this.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		+"\nCPF: " + this.getCpf()
		+"\nRG: " + this.getRg()
		+"\nData de Cadastro: " + this.getCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
}
