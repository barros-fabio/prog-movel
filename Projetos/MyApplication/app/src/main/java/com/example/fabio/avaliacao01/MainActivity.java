package com.example.fabio.avaliacao01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int TASK_ADD_CODE = 23;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = (Button) findViewById(R.id.button);
        bt1.setOnClickListener(onClickBt1Listener);

        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(onClickBt2Listener);

        tv1 = (TextView) findViewById(R.id.textView6);
        tv2 = (TextView) findViewById(R.id.textView7);
        tv3 = (TextView) findViewById(R.id.textView8);
        tv4 = (TextView) findViewById(R.id.textView9);
        tv5 = (TextView) findViewById(R.id.textView10);
    }

    private OnClickListener onClickBt1Listener = new OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(MainActivity.this, Questao2.class);
            startActivity(i);

        }

    };

    private OnClickListener onClickBt2Listener = new OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(MainActivity.this, Questao3.class);
            startActivityForResult(i, TASK_ADD_CODE);
        }

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode ==  TASK_ADD_CODE && resultCode == RESULT_OK){
            NomeContato nome_contato = (NomeContato) data.getSerializableExtra("newContact");

            tv1.setText(nome_contato.getNome());
            tv2.setText(nome_contato.getTipoContato());
            tv3.setText(nome_contato.getEstado());
            tv4.setText(nome_contato.getCuidadoEspecial());
            tv5.setText(nome_contato.getTelefone());

        }
    }
}

