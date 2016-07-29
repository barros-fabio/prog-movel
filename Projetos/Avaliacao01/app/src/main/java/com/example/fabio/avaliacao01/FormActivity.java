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

        //preenchendo ArrayList com as categorias
        cat.add("--");
        cat.add("games");
        cat.add("utilitários");
        cat.add("saude");
        cat.add("social");

        //Spinner usando ArrayList
        categoriaSpinner = (Spinner) findViewById(R.id.spinnerCategoria);
        ArrayAdapter<String> categoriaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cat);
        categoriaSpinner.setAdapter(categoriaAdapter);

        //RadioButton
        btGratis = (RadioButton) findViewById(R.id.gratisButton);
        btPago = (RadioButton) findViewById(R.id.pagoButton);
        btNaoInformado = (RadioButton) findViewById(R.id.naoInformadoButton);

        //Botão Salvar
        Button btSalvar = (Button) findViewById(R.id.botaoSalvar);
        btSalvar.setOnClickListener(onClickBtSalvarListener);
    }

    private View.OnClickListener onClickBtSalvarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String tipoApp = ""; // String intermediária para verificar tipo do app através do RadioButton

            // Validação de dados
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
                // Verifica qual RadioButton está selecionado
                if(btGratis.isChecked()){
                    tipoApp = "Grátis";
                }else if(btPago.isChecked()){
                    tipoApp = "Pago";
                }else if(btNaoInformado.isChecked()){
                    tipoApp = "Não Informado";
                }

                // Constrói objeto do tipo app com o texto recebido dos campos
                App aplicativo = new App(nomeApp.getText().toString(),tipoApp,categoriaSpinner.getSelectedItem().toString());

                // abre nova activity e passa o objeto do tipo app para ela
                Intent i = new Intent(FormActivity.this, Questao4.class);
                i.putExtra("objeto",aplicativo);
                startActivity(i);

            }
        }

    };
}
