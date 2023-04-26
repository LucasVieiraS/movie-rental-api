package br.com.etec.lucas.locadoraApi.repository;

import br.com.etec.lucas.locadoraApi.model.Ator;

import br.com.etec.lucas.locadoraApi.repository.ator.AtorRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long>, AtorRepositoryQuery {

}
