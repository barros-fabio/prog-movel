package com.example.fabio.exercicio2lista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> lista = new ArrayList<>();
    Spinner regiaoSpinner;
    ArrayAdapter<String> listaAdapter;
    private final int TASK_ADD_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lista.add("---");
        lista.add("The Walking Dead");
        lista.add("Dexter");
        lista.add("Breaking Bad");
        Spinner regiaoSpinner = (Spinner) findViewById(R.id.spinner);
        listaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lista);
        regiaoSpinner.setAdapter(listaAdapter);

        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(listener1);
    }

    private OnClickListener listener1 = new OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(MainActivity.this, Adicionar.class);
            startActivityForResult(i, TASK_ADD_CODE);

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode ==  TASK_ADD_CODE && resultCode == RESULT_OK){
            String serieAdicionada = (String)  data.getSerializableExtra("serie");
            lista.add(serieAdicionada);
            listaAdapter.notifyDataSetChanged();

        }
    }
}
