package com.example.fabio.avaliacao01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Questao2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2);

        Button mostrarNome = (Button) findViewById(R.id.mostraNome);
        mostrarNome.setOnClickListener(onClickMostrarNomeListener);

        Button voltarPrincipal = (Button) findViewById(R.id.voltar);
        voltarPrincipal.setOnClickListener(onClickVoltarPrincipalListener);
    }

    private View.OnClickListener onClickMostrarNomeListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Toast.makeText(Questao2.this, "Fabio Barros", Toast.LENGTH_LONG).show();
        }

    };

    private View.OnClickListener onClickVoltarPrincipalListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){

            // Caso o usuario deseje voltar para atividade principal, clica em Sim, caso contrario clica em nao
            AlertDialog.Builder alertDialog =  new AlertDialog.Builder(Questao2.this);
            alertDialog.setTitle("Voltar para a atividade principal");
            alertDialog.setMessage("Deseja voltar?");
            alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Questao2.this.finish();
                }
            });
            alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    Toast.makeText(Questao2.this, "Continua aqui", Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.show();

        }

    };

}
