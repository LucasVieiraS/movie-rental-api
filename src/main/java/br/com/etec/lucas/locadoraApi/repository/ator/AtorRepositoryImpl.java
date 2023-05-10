package br.com.etec.lucas.locadoraApi.repository.ator;

import br.com.etec.lucas.locadoraApi.model.Ator;
import br.com.etec.lucas.locadoraApi.repository.filter.AtorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class AtorRepositoryImpl implements AtorRepositoryQuery {
  @Override
  public Page<Ator> filter(AtorFilter atorFilter, Pageable pageable) {
    return null;
  }
}
