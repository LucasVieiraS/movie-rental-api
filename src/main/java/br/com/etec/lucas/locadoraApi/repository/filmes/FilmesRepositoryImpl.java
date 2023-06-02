package br.com.etec.lucas.locadoraApi.repository.filmes;

import br.com.etec.lucas.locadoraApi.model.Filmes;
import br.com.etec.lucas.locadoraApi.repository.filter.FilmesFilter;
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
  public Page<Filmes> filter(FilmesFilter filmesFilter, Pageable pageable) {
    return
  }
}
