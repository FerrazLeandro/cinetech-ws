package br.com.cinetech.cinetechws.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class FilmeDto {
    private String id;
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;
    private String genero;
    private String diretor;
    @Positive(message = "O ano de lançamento deve ser informado verifique ")
    private Integer ano;
    
    
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
