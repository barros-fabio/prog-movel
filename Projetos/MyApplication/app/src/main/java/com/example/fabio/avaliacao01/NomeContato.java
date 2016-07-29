package com.example.fabio.avaliacao01;

import java.io.Serializable;

/**
 * Created by fabio on 4/8/16.
 */
public class NomeContato implements Serializable {
    private String nome;
    private String tipoContato;
    private String estado;
    private String cuidadoEspecial;
    private String telefone;

    public NomeContato(){

    }

    public NomeContato(String nome, String tipoContato, String estado, String cuidadoEspecial, String telefone){
        this.nome = nome;
        this.tipoContato = tipoContato;
        this.estado = estado;
        this.cuidadoEspecial = cuidadoEspecial;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCuidadoEspecial() {
        return cuidadoEspecial;
    }

    public void setCuidadoEspecial(String cuidadoEspecial) {
        this.cuidadoEspecial = cuidadoEspecial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
