package com.example.fabio.exercicio05lista;

import java.io.Serializable;

/**
 * Created by fabio on 4/3/16.
 */
public class Pessoa implements Serializable {
    private String nome;
    private String sexo;
    private String estado;
    private String cidade;

    public Pessoa(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
