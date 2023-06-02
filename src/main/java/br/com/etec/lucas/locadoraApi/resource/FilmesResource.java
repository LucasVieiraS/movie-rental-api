package br.com.etec.lucas.locadoraApi.resource;

import br.com.etec.lucas.locadoraApi.model.Ator;
import br.com.etec.lucas.locadoraApi.model.Filmes;
import br.com.etec.lucas.locadoraApi.repository.FilmesRepository;
import br.com.etec.lucas.locadoraApi.repository.filter.AtorFilter;
import br.com.etec.lucas.locadoraApi.repository.filter.FilmesFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("filmes")
public class FilmesResource {
    @Autowired
    public FilmesRepository filmesRepository;

    @RequestMapping("/todos")
    public List<Filmes> listarTodosFilmes() {
      return filmesRepository.findAll(Sort.by("nomefilme").ascending());
    }

    @GetMapping()
    public Page<Filmes> pesquisar(FilmesFilter filmesFilter, Pageable pageable) {
      return filmesRepository.filter(filmesFilter, pageable);
    }
}
