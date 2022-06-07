package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.jpa.entity.Movimentacao;

public class MovimentacaoPortariaDAOImpl extends HibernateGenericDAO<Movimentacao, Long> {

	private static MovimentacaoPortariaDAOImpl instance = null;

	private MovimentacaoPortariaDAOImpl() {
		super(Movimentacao.class);
	}

	public static MovimentacaoPortariaDAOImpl getInstance() {

		if (instance == null) {
			instance = new MovimentacaoPortariaDAOImpl();
		}

		return instance;
	}

	public List<Movimentacao> listarPorTipo(String tipo, EntityManager entityManager) {
		String jpql = "SELECT m FROM Movimentacao m WHERE m.tipoMovimentacao = :tipo";

		TypedQuery<Movimentacao> consulta = entityManager.createQuery(jpql, Movimentacao.class);
		consulta.setParameter("tipo", tipo);

		return consulta.getResultList();
	}

}
