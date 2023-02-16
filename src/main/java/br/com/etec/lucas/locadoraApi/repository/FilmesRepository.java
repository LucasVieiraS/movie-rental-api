package br.com.etec.lucas.locadoraApi.repository;

import br.com.etec.lucas.locadoraApi.model.Filmes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Long> {

}
