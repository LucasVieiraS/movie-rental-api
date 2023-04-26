package br.com.etec.lucas.locadoraApi.repository;

import br.com.etec.lucas.locadoraApi.model.Genero;

import br.com.etec.lucas.locadoraApi.repository.genero.GeneroRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>, GeneroRepositoryQuery {

}
