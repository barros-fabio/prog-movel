package com.example.fabio.avaliacao01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog.Builder;

public class Questao2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2);

        Button bt2 = (Button) findViewById(R.id.button3);
        bt2.setOnClickListener(onClickBt2Listener);

        Button bt3 = (Button) findViewById(R.id.button4);
        bt3.setOnClickListener(onClickBt3Listener);
    }

    private View.OnClickListener onClickBt2Listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Toast.makeText(Questao2.this, "Fabio Barros", Toast.LENGTH_SHORT).show();

        }

    };

    private View.OnClickListener onClickBt3Listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Builder alertDialog =  new Builder(Questao2.this);
            alertDialog.setTitle("Voltar para a atividade anterior");
            alertDialog.setMessage("Vai voltar?");
            alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Questao2.this.finish();
                }
            });
            alertDialog.show();

        }

    };
}
