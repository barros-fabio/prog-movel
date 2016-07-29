package com.example.fabio.avaliacao01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import android.widget.CheckBox;

public class Questao3 extends AppCompatActivity {
    Spinner estadoSpinner;
    EditText nome;
    RadioButton btFamilia;
    RadioButton btTrabalho;
    RadioButton btAmigo;
    EditText telefoneContato;
    ArrayList<String> estados = new ArrayList<>();
    CheckBox cuidadoEspecial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao3);

        estados.add("--");
        estados.add("PR");
        estados.add("SP");
        estados.add("MG");
        estados.add("RS");

        nome = (EditText) findViewById(R.id.nomeContato);
        cuidadoEspecial = (CheckBox) findViewById(R.id.checkBox);


        btFamilia = (RadioButton) findViewById(R.id.radioButtonFamiliar);
        btTrabalho= (RadioButton) findViewById(R.id.radioButtonTrabalho);
        btAmigo = (RadioButton) findViewById(R.id.radioButtonAmigo);
        cuidadoEspecial = (CheckBox) findViewById(R.id.checkBox);

        estadoSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> estadoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, estados);
        estadoSpinner.setAdapter(estadoAdapter);

        telefoneContato = (EditText) findViewById(R.id.telefoneContato);


        Button btSalvar = (Button) findViewById(R.id.botaoSalvar);
        btSalvar.setOnClickListener(onClickSalvarListener);


    }

    private View.OnClickListener onClickSalvarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String tipoContato ="";
            String cuidadoEsp = "";

            if(nome.getText().toString().equals("")){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Questao3.this);
                alertDialog.setTitle("Campo obrigatório");
                alertDialog.setMessage("É obrigatório o preenchimento do campo nome!");
                alertDialog.setPositiveButton("OK",null);
                alertDialog.show();
            }else if (estadoSpinner.getSelectedItem().equals("--")){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Questao3.this);
                alertDialog.setTitle("Região inválida");
                alertDialog.setMessage("Região inválida selecionada");
                alertDialog.setPositiveButton("OK", null);
                alertDialog.show();
            }else if (cuidadoEspecial.isChecked()){
                    if(telefoneContato.getText().toString().equals("")) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Questao3.this);
                        alertDialog.setTitle("Telefone de contato obrigatório");
                        alertDialog.setMessage("É necessário inserir um número de telefone!");
                        alertDialog.setPositiveButton("OK", null);
                        alertDialog.show();
                    }
            } else {
                if(btFamilia.isChecked()){
                    tipoContato = "Familia";
                }else if(btTrabalho.isChecked()){
                    tipoContato = "Trabalho";
                }else if(btAmigo.isChecked()){
                    tipoContato = "Amigo";
                }

                if(cuidadoEspecial.isChecked()){
                    cuidadoEsp = "Sim";
                }else{
                    cuidadoEsp = "Não";
                }
                NomeContato nc = new NomeContato(nome.getText().toString(),tipoContato ,estadoSpinner.getSelectedItem().toString(),cuidadoEsp,telefoneContato.getText().toString());
                Intent i = new Intent();
                i.putExtra("newContact", nc);
                setResult(RESULT_OK, i);
                Questao3.this.finish();
            }


        }

    };
}
