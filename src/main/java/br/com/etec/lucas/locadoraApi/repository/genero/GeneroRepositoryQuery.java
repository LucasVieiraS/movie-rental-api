package br.com.etec.lucas.locadoraApi.repository.genero;

import br.com.etec.lucas.locadoraApi.model.Genero;
import br.com.etec.lucas.locadoraApi.repository.filter.GeneroFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneroRepositoryQuery {
  public Page<Genero> filter(GeneroFilter generoFilter, Pageable pageable);
}
