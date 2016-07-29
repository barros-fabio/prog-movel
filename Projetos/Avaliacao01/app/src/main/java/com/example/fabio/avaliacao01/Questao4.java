package com.example.fabio.avaliacao01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Questao4 extends AppCompatActivity {
    TextView nomeApp;
    TextView tipoApp;
    TextView categoriaApp;
    App app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao4);
        app = (App) getIntent().getSerializableExtra("objeto"); // objeto transferido da activity pai


        // Imprime os dados do objeto preenchido na outra classe

        nomeApp = (TextView) findViewById(R.id.nomeApp);
        nomeApp.setText("Nome do App: "+app.getNomeApp());

        tipoApp = (TextView) findViewById(R.id.tipoApp);
        tipoApp.setText("Tipo do App: "+app.getTipoApp());

        categoriaApp = (TextView) findViewById(R.id.categoriaApp);
        categoriaApp.setText("Categoria do App: "+app.getCategoriaApp());
    }


}
