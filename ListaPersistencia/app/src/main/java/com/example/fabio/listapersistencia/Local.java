package com.example.fabio.listapersistencia;

import java.io.Serializable;

/**
 * Created by fabio on 5/4/16.
 */
public class Local implements Serializable {
    String nome;
    String latitude;
    String longitude;

    public Local() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
