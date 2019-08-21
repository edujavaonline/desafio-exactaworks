package com.edujavaonline.gerenciadorgastos.api.repository.gasto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.edujavaonline.gerenciadorgastos.api.model.entity.Gasto;
import com.edujavaonline.gerenciadorgastos.api.repository.filter.GastoFilter;

public class GastoRepositoryImpl implements GastoRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Gasto> filtrar(GastoFilter gastoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Gasto> criteria = builder.createQuery(Gasto.class);
		Root<Gasto> root = criteria.from(Gasto.class);
		
		Predicate[] predicates = criarRestricoes(gastoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Gasto> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(gastoFilter));
	}

	private Predicate[] criarRestricoes(GastoFilter gastoFilter, CriteriaBuilder builder,
			Root<Gasto> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(gastoFilter.getNomePessoa())) {
			predicates.add(builder.like(
					builder.lower(root.get("nomePessoa")), "%" + gastoFilter.getNomePessoa().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(gastoFilter.getDescricao())) {
			predicates.add(builder.like(
					builder.lower(root.get("descricao")), "%" + gastoFilter.getDescricao().toLowerCase() + "%"));
		}
		
		if (gastoFilter.getDataHoraDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get("dataHora"), gastoFilter.getDataHoraDe()));
		}
		
		if (gastoFilter.getDataHoraAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("dataHora"), gastoFilter.getDataHoraAte()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<Gasto> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(GastoFilter gastoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Gasto> root = criteria.from(Gasto.class);
		
		Predicate[] predicates = criarRestricoes(gastoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
