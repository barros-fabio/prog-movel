package com.example.fabio.exercicio05lista;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by fabio on 4/3/16.
 */
public class Informacoes extends Activity {
    Pessoa pes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacoes);
        pes = (Pessoa) getIntent().getSerializableExtra("info");
        Log.d("informações",pes.toString());

        TextView nomeTV = (TextView) findViewById(R.id.nome);
        nomeTV.setText(pes.getNome());
        TextView generoTV = (TextView) findViewById(R.id.sexo);
        generoTV.setText(pes.getSexo());
        TextView estadoTV = (TextView) findViewById(R.id.estado);
        estadoTV.setText(pes.getEstado());
        TextView cidadeTV = (TextView) findViewById(R.id.cidade);
        cidadeTV.setText(pes.getCidade());
    }
}
