package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.FuncionarioDAOImpl;
import br.com.fiap.jpa.entity.FuncionarioPortaria;
import br.com.fiap.jpa.service.GenericService;

public class FuncionarioServiceImpl extends GenericService<FuncionarioPortaria, Long> {

	private static FuncionarioServiceImpl instance = null;

	private FuncionarioDAOImpl funcionarioDAO;

	private FuncionarioServiceImpl () {
		this.funcionarioDAO = FuncionarioDAOImpl.getInstance();
	}

	public static FuncionarioServiceImpl getInstance() {

		if (instance == null) {
			instance = new FuncionarioServiceImpl();
		}

		return instance;
	}

	@Override
	public void inserir(FuncionarioPortaria instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(FuncionarioPortaria instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public FuncionarioPortaria obter(Long id) {
		FuncionarioPortaria funcionario = null;

		try {
			funcionario = funcionarioDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}

		return funcionario;
	}

	@Override
	public List<FuncionarioPortaria> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
