package com.example.fabio.avaliacao01parte01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.app.AlertDialog.Builder;
import android.view.View.OnClickListener;


import java.util.ArrayList;
import android.widget.CheckBox;

/**
 * Created by fabio on 4/7/16.
 */
public class Questao3 extends Activity{
    EditText nome;
    RadioButton btMasc;
    RadioButton btFem;
    Spinner regiaoSpinner;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questao3);
        ArrayList<String> reg = new ArrayList<>();
        reg.add("--");
        reg.add("Sul");
        reg.add("Sudeste");
        reg.add("Nordeste");
        reg.add("Norte");
        reg.add("Centro-Oeste");

        nome = (EditText) findViewById(R.id.nome);

        btMasc = (RadioButton) findViewById(R.id.masc);
        btFem = (RadioButton) findViewById(R.id.fem);

        regiaoSpinner = (Spinner) findViewById(R.id.regioes);
        ArrayAdapter<String> regiaoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, reg);
        regiaoSpinner.setAdapter(regiaoAdapter);

        salvar = (Button) findViewById(R.id.salvar);
        salvar.setOnClickListener(salvarListener);
    }

    private OnClickListener salvarListener = new OnClickListener(){
        @Override
        public void onClick(View v){
            boolean checked = ((RadioButton) v).isChecked();
            if(nome.getText().toString().equals("")){
                Builder alertDialog = new Builder(Questao3.this);
                alertDialog.setTitle("Campo obrigatório");
                alertDialog.setMessage("É obrigatório o preenchimento do campo nome!");
                alertDialog.setPositiveButton("OK",null);
                alertDialog.show();
            }else if (regiaoSpinner.getSelectedItem().equals("--")){
                Builder alertDialog = new Builder(Questao3.this);
                alertDialog.setTitle("Região inválida");
                alertDialog.setMessage("Região inválida selecionada");
                alertDialog.setPositiveButton("OK", null);
                alertDialog.show();
            }

            Intent i = new Intent(Questao3.this, Sumario.class);
            i.putExtra("name", nome.getText());

            if(checked) {
                switch ( v.getId() ) {
                    case R.id.masc:
                        i.putExtra("genre", "Masculino");
                        break;
                    case R.id.fem:
                        i.putExtra("genre", "Feminino");
                        break;
                }
            }


            i.putExtra("region", regiaoSpinner.getSelectedItem().toString());
            startActivity(i);
        }
    };


}
