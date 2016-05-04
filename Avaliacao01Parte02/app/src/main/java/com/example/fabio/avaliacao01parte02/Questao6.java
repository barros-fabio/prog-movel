package com.example.fabio.avaliacao01parte02;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class Questao6 extends AppCompatActivity {
    Button salvar;
    EditText memory, nomeUsuario;
    RadioButton comSD, semSD;
    Spinner opcoes;
    ArrayList<String> op = new ArrayList<>();
    String SDcard, nome, spinnerOp;
    int memoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao6);

        SharedPreferences preferences = getSharedPreferences("questao6", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("spinner1","não selecionado");
        editor.putString("spinner2","Android");
        editor.putString("spinner3","iPhone");
        editor.putString("spinner4","Windows Phone");

        editor.putString("nome","Fabio");
        editor.putString("sd","Com Cartão SD");
        editor.putInt("ram", 2);
        editor.commit();

        opcoes = (Spinner) findViewById(R.id.spinner);
        salvar = (Button) findViewById(R.id.button);
        comSD = (RadioButton) findViewById(R.id.radioButton);
        semSD = (RadioButton) findViewById(R.id.radioButton2);
        memory = (EditText) findViewById(R.id.editText);
        nomeUsuario = (EditText) findViewById(R.id.editText2);
        opcoes = (Spinner) findViewById(R.id.spinner);

        salvar.setOnClickListener(botaoSalvarListener);

        op.add(preferences.getString("spinner1","Não definido"));
        op.add(preferences.getString("spinner2","Não definido"));
        op.add(preferences.getString("spinner3","Não definido"));
        op.add(preferences.getString("spinner4","Não definido"));

        ArrayAdapter<String> opAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,op);
        opcoes.setAdapter(opAdapter);
    }

    private View.OnClickListener botaoSalvarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences preferences = getSharedPreferences("questao6", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            spinnerOp = opcoes.getSelectedItem().toString();
            nome = nomeUsuario.getText().toString();
            memoria = Integer.parseInt(memory.getText().toString());


            if(comSD.isChecked()){
                SDcard = "Com Cartão SD";
            }else if(semSD.isChecked()){
                SDcard = "Sem Cartão SD";
            }

            editor.putString("spinner1",spinnerOp);
            editor.putString("nome",nome);
            editor.putString("sd",SDcard);
            editor.putInt("ram", memoria);
            editor.commit();
        }
    };
}
