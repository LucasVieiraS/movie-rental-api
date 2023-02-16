package br.com.etec.lucas.locadoraApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="filmes")
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(mappedBy = "genero")
    @JsonIgnore
    private List<Genero> genero = new ArrayList<>();

    @OneToMany(mappedBy = "ator")
    @JsonIgnore
    private List<Ator> ator = new ArrayList<>();

    private String nomefilme;
    private Long idgenero;
    private Long idator;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Genero> getEnredo() {
        return genero;
    }

    public void setEnredo(List<Genero> enredo) {
        this.genero = enredo;
    }

    public List<Ator> getAtor() {
        return ator;
    }

    public void setAtor(List<Ator> ator) {
        this.ator = ator;
    }

    public String getNomefilme() {
        return nomefilme;
    }

    public void setNomefilme(String nomefilme) {
        this.nomefilme = nomefilme;
    }

    public Long getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Long idgenero) {
        this.idgenero = idgenero;
    }

    public Long getIdator() {
        return idator;
    }

    public void setIdator(Long idator) {
        this.idator = idator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filmes filmes = (Filmes) o;
        return Id.equals(filmes.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
