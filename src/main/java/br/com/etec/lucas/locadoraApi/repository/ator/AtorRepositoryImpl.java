package br.com.etec.lucas.locadoraApi.repository.ator;

import br.com.etec.lucas.locadoraApi.model.Ator;
import br.com.etec.lucas.locadoraApi.model.Ator;
import br.com.etec.lucas.locadoraApi.repository.filter.AtorFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AtorRepositoryImpl implements AtorRepositoryQuery {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Ator> filter(AtorFilter atorFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Ator> criteria = builder.createQuery(Ator.class);
    Root<Ator> root = criteria.from(Ator.class);

    Predicate[] predicates = createRestrictions(atorFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));

    TypedQuery<Ator> query = manager.createQuery(criteria);
    addPaginationRestrictions(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, getTotal(atorFilter));
  }

  private Long getTotal(AtorFilter atorFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Ator> root = criteria.from(Ator.class);

    Predicate[] predicates = createRestrictions(atorFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nome")));

    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }

  private void addPaginationRestrictions(TypedQuery<?> query, Pageable pageable) {
    int currentPage = pageable.getPageNumber();
    int totalRegistersPerPage = pageable.getPageSize();
    int firstPageRegister = currentPage * totalRegistersPerPage;

    query.setFirstResult(firstPageRegister);
    query.setMaxResults(totalRegistersPerPage);
  }

  private Predicate[] createRestrictions(AtorFilter atorFilter, CriteriaBuilder builder, Root<Ator> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(atorFilter.getNome())) {
      predicates.add(
        builder.like(
          builder.lower(root.get("nome")),
          "%" + atorFilter.getNome().toLowerCase() + '%'
        )
      );
    }

    return predicates.toArray((new Predicate[predicates.size()]));
  }
}
