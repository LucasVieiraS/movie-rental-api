package br.com.etec.lucas.locadoraApi.repository.filmes;

import br.com.etec.lucas.locadoraApi.model.Filmes;
import br.com.etec.lucas.locadoraApi.repository.filter.FilmesFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmesRepositoryQuery {
  public Page<Filmes> filter(FilmesFilter filmesFilter, Pageable pageable);
}
