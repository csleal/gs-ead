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

import br.com.fiap.jpa.entity.FuncionarioPortaria;

public class FuncionarioDAOImpl extends HibernateGenericDAO<FuncionarioPortaria, Long>{
	
	private static FuncionarioDAOImpl instance = null;
	
	private FuncionarioDAOImpl() {
		super(FuncionarioPortaria.class);
	}
	
	public static FuncionarioDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new FuncionarioDAOImpl();
		}
		
		return instance;
	}
	
//	public List<FuncionarioPortaria> pesquisar(String nome, String cpf, LocalDate cadastro, 
//			EntityManager entityManager) {
//		
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<FuncionarioPortaria> criteriaQuery = builder.createQuery(FuncionarioPortaria.class);
//		
//		Root<FuncionarioPortaria> funcionarioPortaria = criteriaQuery.from(FuncionarioPortaria.class);
//		
//		List<Predicate> predicates = new ArrayList<>();
//		
//		if (nome != null) {
//			Predicate predicate = builder.like(
//					builder.upper(funcionarioPortaria.get("nome")), "%" + nome.toUpperCase() + "%");
//			predicates.add(predicate);
//		}
//		
//		if (cpf != null) {
//			Predicate predicate = builder.equal(funcionarioPortaria.get("cpf"), cpf);
//			predicates.add(predicate);
//		}
//		
//		if (cadastro != null) {
//			Predicate predicate = builder.greaterThanOrEqualTo(
//					funcionarioPortaria.get("cadastro"), cadastro);
//			predicates.add(predicate);
//		}
//		
//		criteriaQuery.select(funcionarioPortaria);
//		criteriaQuery.where(predicates.toArray(new Predicate[0]));
//		
//		TypedQuery<FuncionarioPortaria> consulta = entityManager.createQuery(criteriaQuery);
//		
//		return consulta.getResultList();
//	}
	
}
