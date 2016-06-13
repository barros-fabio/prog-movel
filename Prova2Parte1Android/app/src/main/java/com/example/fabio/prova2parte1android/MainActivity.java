package com.example.fabio.prova2parte1android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button todosFuncionarios, pesquisarFuncionario, adicionarFuncionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todosFuncionarios = (Button) findViewById(R.id.todosFunc);
        pesquisarFuncionario = (Button) findViewById(R.id.consultaFunc);
        adicionarFuncionario = (Button) findViewById(R.id.cadastroFunc);

        todosFuncionarios.setOnClickListener(botaoTodosListener);
        pesquisarFuncionario.setOnClickListener(botaoPesquisarListener);
        adicionarFuncionario.setOnClickListener(botaoCadastrarListener);

    }

    private View.OnClickListener botaoTodosListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){

            Intent i = new Intent(MainActivity.this, TodosFuncionarios.class);
            startActivity(i);

        }
    };

    private View.OnClickListener botaoPesquisarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){

            Intent i = new Intent(MainActivity.this, ConsultaFuncionario.class);
            startActivity(i);

        }
    };

    private View.OnClickListener botaoCadastrarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){

            Intent i = new Intent(MainActivity.this, CadastraFuncionario.class);
            startActivity(i);

        }
    };
}
