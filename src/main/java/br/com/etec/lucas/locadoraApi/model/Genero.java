package br.com.etec.lucas.locadoraApi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "filmesid")
    private Filmes filmes;

    private String descricao;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Filmes getFilmes() {
        return filmes;
    }

    public void setFilmes(Filmes filmes) {
        this.filmes = filmes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Id.equals(genero.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
