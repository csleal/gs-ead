package br.com.fiap.jpa.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.fiap.jpa.entity.Visitante;

public class VisitanteDAOImpl extends HibernateGenericDAO<Visitante, Long>{
	
	private static VisitanteDAOImpl instance = null;
	
	private VisitanteDAOImpl() {
		super(Visitante.class);
	}
	
	public static VisitanteDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new VisitanteDAOImpl();
		}
		
		return instance;
	}
	
	public List<Visitante> pesquisar(String nome, String cpf, LocalDate cadastro, 
			EntityManager entityManager) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Visitante> criteriaQuery = builder.createQuery(Visitante.class);
		
		Root<Visitante> visitante = criteriaQuery.from(Visitante.class);
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (nome != null) {
			Predicate predicate = builder.like(
					builder.upper(visitante.get("nome")), "%" + nome.toUpperCase() + "%");
			predicates.add(predicate);
		}
		
		if (cpf != null) {
			Predicate predicate = builder.equal(visitante.get("cpf"), cpf);
			predicates.add(predicate);
		}
		
		if (cadastro != null) {
			Predicate predicate = builder.greaterThanOrEqualTo(
					visitante.get("cadastro"), cadastro);
			predicates.add(predicate);
		}
		
		criteriaQuery.select(visitante);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Visitante> consulta = entityManager.createQuery(criteriaQuery);
		
		return consulta.getResultList();
	}

}
