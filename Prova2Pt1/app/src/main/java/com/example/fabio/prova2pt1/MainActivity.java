package com.example.fabio.prova2pt1;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pesquisaTarefa, inserirTarefa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesquisaTarefa = (Button) findViewById(R.id.pesquisaTarefa);
        inserirTarefa = (Button) findViewById(R.id.inserirTarefa);

        pesquisaTarefa.setOnClickListener(botaoPesquisarListener);
        inserirTarefa.setOnClickListener(botaoInserirListener);

    }

    private View.OnClickListener botaoPesquisarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){

            Intent i = new Intent(MainActivity.this, PesquisaTarefa.class);
            startActivity(i);

        }
    };

    private View.OnClickListener botaoInserirListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(MainActivity.this, InserirTarefa.class);
            startActivity(i);
        }
    };


    /**
     * verify if it is connected in some network
     *
     * @return
     */


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null
                && activeNetworkInfo.isConnectedOrConnecting();
    }
}
