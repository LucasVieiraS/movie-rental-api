package br.com.etec.lucas.locadoraApi.resource;

import br.com.etec.lucas.locadoraApi.model.Ator;
import br.com.etec.lucas.locadoraApi.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("atores")
public class AtorResource {
    @Autowired
    public AtorRepository atorRepository;

    @RequestMapping("/todos")
    public List<Ator> listarTodosAtores() {
        return atorRepository.findAll();
    }
}
