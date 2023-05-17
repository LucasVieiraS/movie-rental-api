package br.com.etec.lucas.locadoraApi.repository.genero;

import br.com.etec.lucas.locadoraApi.model.Genero;
import br.com.etec.lucas.locadoraApi.repository.filter.GeneroFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
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
import java.util.Locale;

public class GeneroRepositoryImpl implements GeneroRepositoryQuery {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Genero> filter(GeneroFilter generoFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Genero> criteria = builder.createQuery(Genero.class);
    Root<Genero> root = criteria.from(Genero.class);

    Predicate[] predicates = criarRestricoes(generoFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("descricao")));

    TypedQuery<Genero> query = manager.createQuery(criteria);

    return null;
  }

  private Predicate[] criarRestricoes(GeneroFilter generoFilter, CriteriaBuilder builder, Root<Genero> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(generoFilter.getDescricao())) {
      predicates.add(
        builder.like(
          builder.lower(root.get("descricao")),
        "%" + generoFilter.getDescricao().toLowerCase() + '%'
        )
      );
    }

    return predicates.toArray((new Predicate[predicates.size()]));
  }
}
