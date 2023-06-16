package br.com.etec.lucas.locadoraApi.repository.filmes;

import br.com.etec.lucas.locadoraApi.model.Filmes;
import br.com.etec.lucas.locadoraApi.repository.filter.FilmesFilter;
import br.com.etec.lucas.locadoraApi.repository.projections.FilmesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmesRepositoryQuery {
  public Page<FilmesDTO> filter(FilmesFilter filmesFilter, Pageable pageable);
}
