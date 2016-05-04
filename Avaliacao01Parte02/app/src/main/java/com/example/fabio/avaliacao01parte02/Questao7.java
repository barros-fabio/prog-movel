package com.example.fabio.avaliacao01parte02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Questao7 extends AppCompatActivity {
    Button inserir, consultar;
    private final int TASK_ADD_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao7);

        inserir = (Button) findViewById(R.id.buttonInserir);
        consultar = (Button) findViewById(R.id.buttonConsulta);

        inserir.setOnClickListener(botaoInserirListener);
        consultar.setOnClickListener(botaoConsultarListener);


    }

    private View.OnClickListener botaoInserirListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(Questao7.this, InserirQuestao7.class );
            startActivityForResult(i, TASK_ADD_CODE);
        }
    };



    private View.OnClickListener botaoConsultarListener = new View.OnClickListener(){
      @Override
      public void onClick(View v){
          Intent i = new Intent(Questao7.this,ConsultaQuestao8.class);
          startActivity(i);
      }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == TASK_ADD_CODE && resultCode == RESULT_OK){

        }
    }
}
