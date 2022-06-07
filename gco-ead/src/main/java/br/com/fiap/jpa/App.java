package br.com.fiap.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fiap.jpa.entity.Condominio;
import br.com.fiap.jpa.entity.FuncionarioPortaria;
import br.com.fiap.jpa.entity.Movimentacao;
import br.com.fiap.jpa.entity.Portaria;
import br.com.fiap.jpa.entity.Visitante;
import br.com.fiap.jpa.service.impl.CondominioServiceImpl;
import br.com.fiap.jpa.service.impl.FuncionarioServiceImpl;
import br.com.fiap.jpa.service.impl.MovimentacaoPortariaServiceImpl;
import br.com.fiap.jpa.service.impl.PortariaServiceImpl;
import br.com.fiap.jpa.service.impl.VisitanteServiceImpl;

public class App {

	public static void main(String[] args) {
		
		CondominioServiceImpl condominioService = CondominioServiceImpl.getInstance();
		PortariaServiceImpl portariaService = PortariaServiceImpl.getInstance();
		VisitanteServiceImpl visitanteService = VisitanteServiceImpl.getInstance();
		FuncionarioServiceImpl funcionarioService = FuncionarioServiceImpl.getInstance();
		MovimentacaoPortariaServiceImpl movimentacaoPortariaService = MovimentacaoPortariaServiceImpl.getInstance();
		
		/**
		 * Cadastrar um novo Condominio
		 */
		
		Condominio condominio = new Condominio("11382807002", "Condominio01", "Flex", LocalDate.of(2022, 1, 1));
		
		condominioService.inserir(condominio);
		
		/**
		 *Cadastre duas Portarias, uma com o nome “Principal” e outra com o
		 * nome “Serviço”, associando a elas o condomínio criado no item 9.1
		 */
		
		Portaria portaria1 = new Portaria(1,"Principal","Ativa", LocalDate.of(2021, 1, 12), LocalDate.of(2022, 7, 1), condominio);
		Portaria portaria2 = new Portaria(2,"Serviço","Ativa", LocalDate.of(2021, 1, 12), LocalDate.of(2022, 7, 1), condominio);
		
		portariaService.inserir(portaria1);
		portariaService.inserir(portaria2);
		
		/**
		 * Associada à portaria Principal, cadastre as movimentações com os seguintes dados:
		 * - Funcionário com id 1, Visitante com id 1, Tipo ‘E’, Data da movimentação 2022-06-01 15:00:00
		 * - Funcionário com id 1, Visitante com id 2, Tipo ‘E’, Data da movimentação 2022-06-01 15:30:00
		 * - Funcionário com id 2, Visitante com id 1, Tipo ‘S’, Data da movimentação 2022-06-01 15:45:00
		 */
		
		FuncionarioPortaria funcionario1 = funcionarioService.obter(1L);
		FuncionarioPortaria funcionario2 = funcionarioService.obter(2L);
		Visitante visitante1 = visitanteService.obter(1L);
		Visitante visitante2 = visitanteService.obter(2L);
		
		Movimentacao movimentacao1 = new Movimentacao("E", LocalDateTime.of(2022, 6, 1, 15, 0, 0), portaria1, funcionario1, visitante1);
		Movimentacao movimentacao2 = new Movimentacao("E", LocalDateTime.of(2022, 6, 1, 15, 30, 0), portaria1, funcionario1, visitante2);
		Movimentacao movimentacao3 = new Movimentacao("S", LocalDateTime.of(2022, 6, 1, 15, 45, 0), portaria1, funcionario2, visitante1);
		
		movimentacaoPortariaService.inserir(movimentacao1);
		movimentacaoPortariaService.inserir(movimentacao2);
		movimentacaoPortariaService.inserir(movimentacao3);
		
		/**
		 * 9.4 – Liste todas as movimentações com base no tipo da movimentação
		 */
		
		movimentacaoPortariaService.listarTipo("E").forEach(System.out::println);
		
		/**
		 * 9.5 – Crie uma consulta que será montada dinamicamente para pesquisar
		 * os visitantes cadastrados com base nos seguintes filtros: nome, cpf e data de cadastro
		 */
		
		visitanteService.pesquisar("m", null, null).forEach(System.out::println);
		visitanteService.pesquisar("j", "444.444.444-44", null).forEach(System.out::println);
	}
}
