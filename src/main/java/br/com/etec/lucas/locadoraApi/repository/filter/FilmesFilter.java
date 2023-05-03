package br.com.etec.lucas.locadoraApi.repository.filter;

public class FilmesFilter {

  private String nomefilme;
  private String nomeator;
  private String nomegenero;

  public String getNomefilme() {
    return nomefilme;
  }

  public void setNomefilme(String nomefilme) {
    this.nomefilme = nomefilme;
  }

  public String getNomeator() {
    return nomeator;
  }

  public void setNomeator(String nomeator) {
    this.nomeator = nomeator;
  }

  public String getNomegenero() {
    return nomegenero;
  }

  public void setNomegenero(String nomegenero) {
    this.nomegenero = nomegenero;
  }
}
