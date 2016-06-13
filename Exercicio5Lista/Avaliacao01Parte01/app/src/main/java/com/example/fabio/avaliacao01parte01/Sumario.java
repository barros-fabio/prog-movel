package com.example.fabio.avaliacao01parte01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



/**
 * Created by fabio on 4/7/16.
 */
public class Sumario extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sumario);

        String nome = getIntent().getStringExtra("name");
        String genero = getIntent().getStringExtra("genre");
        String regiao = getIntent().getStringExtra("region");

        TextView nomePessoa = (TextView) findViewById(R.id.nome);
        nomePessoa.setText(nome);

        TextView generoPessoa = (TextView) findViewById(R.id.generoPessoa);
        generoPessoa.setText(genero);

        TextView regiaoPessoa = (TextView) findViewById(R.id.regiaoPessoa);
        regiaoPessoa.setText(regiao);
    }
}
