    package com.example.fabio.avaliacao01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt2 = (Button) findViewById(R.id.questao2);
        bt2.setOnClickListener(onClickBt2Listener);

        Button bt3 = (Button) findViewById(R.id.questao3);
        bt3.setOnClickListener(onClickBt3Listener);
    }

    private View.OnClickListener onClickBt2Listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(MainActivity.this, Questao2.class);
            startActivity(i);

        }

    };

    private View.OnClickListener onClickBt3Listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(MainActivity.this, FormActivity.class);
            startActivity(i);
        }

    };
}
