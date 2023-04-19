package br.com.etec.lucas.locadoraApi.resource;

import br.com.etec.lucas.locadoraApi.model.Genero;
import br.com.etec.lucas.locadoraApi.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroResource {
    @Autowired
    public GeneroRepository generoRepository;

    @RequestMapping("/todos")
    public List<Genero> listarTodosGeneros() {
        return generoRepository.findAll(Sort.by("descricao").ascending());
    }
}