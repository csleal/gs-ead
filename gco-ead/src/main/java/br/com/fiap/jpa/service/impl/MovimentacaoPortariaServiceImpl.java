package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.MovimentacaoPortariaDAOImpl;
import br.com.fiap.jpa.entity.Movimentacao;
import br.com.fiap.jpa.service.GenericService;

public class MovimentacaoPortariaServiceImpl extends GenericService<Movimentacao, Long> {
	
	private static MovimentacaoPortariaServiceImpl instance = null;
	
	private MovimentacaoPortariaDAOImpl movimentacaoPortariaDAO;
	
	private MovimentacaoPortariaServiceImpl() {
		this.movimentacaoPortariaDAO = MovimentacaoPortariaDAOImpl.getInstance();
	}
	
	public static MovimentacaoPortariaServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new MovimentacaoPortariaServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Movimentacao instance) {
		try {
			movimentacaoPortariaDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void atualizar(Movimentacao instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Movimentacao obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimentacao> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Movimentacao> listarTipo(String tipo) {
		List<Movimentacao> movimentacoes = null;
		
		try {
			movimentacoes = movimentacaoPortariaDAO.listarPorTipo(tipo, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return movimentacoes;
	}

}
