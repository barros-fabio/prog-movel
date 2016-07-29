package com.example.fabio.avaliacao01;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {
    EditText nomeApp;
    Spinner categoriaSpinner;
    ArrayList<String> cat = new ArrayList<>();
    RadioButton btGratis;
    RadioButton btPago;
    RadioButton btNaoInformado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        nomeApp = (EditText) findViewById(R.id.nomeApp);

        cat.add("--");
        cat.add("games");
        cat.add("utilitários");
        cat.add("saude");
        cat.add("social");

        categoriaSpinner = (Spinner) findViewById(R.id.spinnerCategoria);
        ArrayAdapter<String> categoriaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cat);
        categoriaSpinner.setAdapter(categoriaAdapter);

        btGratis = (RadioButton) findViewById(R.id.gratisButton);
        btPago = (RadioButton) findViewById(R.id.pagoButton);
        btNaoInformado = (RadioButton) findViewById(R.id.naoInformadoButton);

        Button btSalvar = (Button) findViewById(R.id.botaoSalvar);
        btSalvar.setOnClickListener(onClickBtSalvarListener);
    }

    private View.OnClickListener onClickBtSalvarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(nomeApp.getText().toString().equals("")){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(FormActivity.this);
                alertDialog.setTitle("Campo obrigatório");
                alertDialog.setMessage("É obrigatório o preenchimento do campo nome!");
                alertDialog.setPositiveButton("OK",null);
                alertDialog.show();
            }else if (categoriaSpinner.getSelectedItem().equals("--")){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(FormActivity.this);
                alertDialog.setTitle("Categoria inválida");
                alertDialog.setMessage("Categoria inválida selecionada");
                alertDialog.setPositiveButton("OK", null);
                alertDialog.show();
            }else if(btPago.isChecked()){
                if(categoriaSpinner.getSelectedItem().equals("social")){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(FormActivity.this);
                    alertDialog.setTitle("Categoria inválida");
                    alertDialog.setMessage("Categoria social é inválida para apps pagos!");
                    alertDialog.setPositiveButton("OK", null);
                    alertDialog.show();
                }
            }else{

            }
        }

    };
}
