package com.example.fabio.exercicio2;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bSalvar = (Button) findViewById(R.id.saveButton);
        bSalvar.setOnClickListener(botaoSalvar);
    }

    private OnClickListener botaoSalvar = new OnClickListener(){
        @Override
        public void onClick(View v) {
            int id = 0;
            int peso = 0;

            EditText nomeEditText = (EditText) findViewById(R.id.nome);
            String nomeStr = nomeEditText.getText().toString();

            EditText passwordEditText = (EditText) findViewById(R.id.password);
            String passwordStr = passwordEditText.getText().toString();

            EditText emailEditText = (EditText) findViewById(R.id.email);
            String emailStr = emailEditText.getText().toString();

            EditText telEditText = (EditText) findViewById(R.id.telefone);

            EditText idEditText = (EditText) findViewById(R.id.idade);
            EditText pesoEditText = (EditText) findViewById(R.id.peso);
            id = Integer.parseInt(idEditText.getText().toString());
            peso = Integer.parseInt(pesoEditText.getText().toString());

            if((nomeStr.equals(""))||( passwordStr.equals(""))||(emailStr.equals(""))){
                Builder alertDialog = new Builder(MainActivity.this);
                alertDialog.setTitle("Campo vazio - Erro");
                alertDialog.setMessage("Campo obrigatório vazio! Preencha o campo!");
                alertDialog.setPositiveButton("OK", null);
                alertDialog.show();
            }else{
                if(id<5 || id>99){
                    Builder alertDialog = new Builder(MainActivity.this);
                    alertDialog.setTitle("Idade invalida");
                    alertDialog.setMessage("Idade fora da faixa valida!");
                    alertDialog.setPositiveButton("OK",null);
                    alertDialog.show();
                }

                if(peso<1 || peso>200){
                    Builder alertDialog = new Builder(MainActivity.this);
                    alertDialog.setTitle("Peso invalido");
                    alertDialog.setMessage("Peso fora da faixa valida!");
                    alertDialog.setPositiveButton("OK",null);
                    alertDialog.show();
                }

                Toast toast = Toast.makeText(MainActivity.this, "Dados preenchidos corretamente! Contato Salvo!",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                nomeEditText.setText("");
                passwordEditText.setText("");
                emailEditText.setText("");
                idEditText.setText("");
                telEditText.setText("");
                pesoEditText.setText("");
            }

        }
    };
}


