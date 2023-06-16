package br.com.etec.lucas.locadoraApi.repository.filmes;

import br.com.etec.lucas.locadoraApi.model.Filmes;
import br.com.etec.lucas.locadoraApi.repository.filter.FilmesFilter;
import br.com.etec.lucas.locadoraApi.repository.projections.FilmesDTO;
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

public class FilmesRepositoryImpl implements FilmesRepositoryQuery {
  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<FilmesDTO> filter(FilmesFilter filmesFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<FilmesDTO> criteria = builder.createQuery(FilmesDTO.class);
    Root<Filmes> root = criteria.from(Filmes.class);

    criteria.select(builder.construct(FilmesDTO.class,
      root.get("id"),
      root.get("nomefilme"),
      root.get("genero").get("descricao"),
      root.get("ator").get("nome")
    ));

    Predicate[] predicates = createRestrictions(filmesFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomefilme")));

    TypedQuery<FilmesDTO> query = manager.createQuery(criteria);
    addPaginationRestrictions(query, pageable);

    return new PageImpl<FilmesDTO>(query.getResultList(), pageable, getTotal(filmesFilter));
  }

  private Predicate[] createRestrictions(FilmesFilter filmesFilter, CriteriaBuilder builder, Root<Filmes> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(filmesFilter.getNomefilme())) {
      System.out.println(root.get("nomefilme"));
      predicates.add(
        builder.like(
          builder.lower(root.get("nomefilme")),
          "%" + filmesFilter.getNomefilme().toLowerCase() + '%'
        )
      );
    }

    if (!StringUtils.isEmpty(filmesFilter.getNomegenero())) {
      predicates.add(
        builder.like(
          builder.lower(root.get("genero").get("descricao")),
          "%" + filmesFilter.getNomegenero().toLowerCase() + '%'
        )
      );
    }

    if (!StringUtils.isEmpty(filmesFilter.getNomeator())) {
      predicates.add(
        builder.like(
          builder.lower(root.get("ator").get("nome")),
          "%" + filmesFilter.getNomeator().toLowerCase() + '%'
        )
      );
    }

    return predicates.toArray((new Predicate[predicates.size()]));
  }

  private void addPaginationRestrictions(TypedQuery<?> query, Pageable pageable) {
    int currentPage = pageable.getPageNumber();
    int totalRegistersPerPage = pageable.getPageSize();
    int firstPageRegister = currentPage * totalRegistersPerPage;

    query.setFirstResult(firstPageRegister);
    query.setMaxResults(totalRegistersPerPage);
  }

  private Long getTotal(FilmesFilter filmesFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Filmes> root = criteria.from(Filmes.class);

    Predicate[] predicates = createRestrictions(filmesFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomefilme")));

    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }

}
