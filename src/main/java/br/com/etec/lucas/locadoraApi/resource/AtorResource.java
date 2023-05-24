package br.com.etec.lucas.locadoraApi.resource;

import br.com.etec.lucas.locadoraApi.model.Ator;
import br.com.etec.lucas.locadoraApi.repository.AtorRepository;
import br.com.etec.lucas.locadoraApi.repository.filter.AtorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("atores")
public class AtorResource {
    @Autowired
    public AtorRepository atorRepository;

    @GetMapping("/todos")
    public List<Ator> listarTodosAtores() {
        return atorRepository.findAll();
    }

    @GetMapping()
    public Page<Ator> pesquisar(AtorFilter atorFilter, Pageable pageable) {
      return atorRepository.filter(atorFilter, pageable);
    }
}
