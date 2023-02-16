package br.com.etec.lucas.locadoraApi.resource;

import br.com.etec.lucas.locadoraApi.model.Filmes;
import br.com.etec.lucas.locadoraApi.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return filmesRepository.findAll();
    }
}