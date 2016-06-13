package com.example.fabio.avaliacao01parte01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt2 = (Button) findViewById(R.id.questao2);
        bt2.setOnClickListener(questao2Listener);

        Button bt3 = (Button) findViewById(R.id.questao34);
        bt3.setOnClickListener(questao34Listener);


    }

    private OnClickListener questao2Listener = new OnClickListener(){
        @Override
        public void onClick(View v){
            Toast.makeText(MainActivity.this, "Questão 2 Realizada com sucesso!!!!", Toast.LENGTH_SHORT).show();
        }
    };

    private OnClickListener questao34Listener = new OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(MainActivity.this, Questao3.class);
            startActivity(i);
        }
    };
}
