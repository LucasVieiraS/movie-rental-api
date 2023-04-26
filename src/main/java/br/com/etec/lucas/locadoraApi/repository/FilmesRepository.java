package br.com.etec.lucas.locadoraApi.repository;

import br.com.etec.lucas.locadoraApi.model.Filmes;

import br.com.etec.lucas.locadoraApi.repository.filmes.FilmesRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Long>, FilmesRepositoryQuery {

}
