package com.example.fabio.avaliacao01;

import java.io.Serializable;

/**
 * Created by fabio on 4/8/16.
 */
public class App implements Serializable {
    private String nomeApp;
    private String tipoApp;
    private String categoriaApp;

    // Construtor
    public App(String nomeApp, String tipoApp, String categoriaApp){
        this.nomeApp = nomeApp;
        this.tipoApp = tipoApp;
        this.categoriaApp = categoriaApp;
    }


    // Getters e setters
    public String getNomeApp() {
        return nomeApp;
    }

    public void setNomeApp(String nomeApp) {
        this.nomeApp = nomeApp;
    }

    public String getTipoApp() {
        return tipoApp;
    }

    public void setTipoApp(String tipoApp) {
        this.tipoApp = tipoApp;
    }

    public String getCategoriaApp() {
        return categoriaApp;
    }

    public void setCategoriaApp(String categoriaApp) {
        this.categoriaApp = categoriaApp;
    }
}
