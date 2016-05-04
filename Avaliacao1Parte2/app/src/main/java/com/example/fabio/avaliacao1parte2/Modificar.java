package com.example.fabio.avaliacao1parte2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Modificar extends AppCompatActivity {
    EditText nome;
    EditText idade;
    RadioButton btMasc;
    RadioButton btFem;
    Button save;
    String name;
    String genre;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        nome = (EditText) findViewById(R.id.novoNome);
        idade = (EditText) findViewById(R.id.idadeNova);
        save = (Button) findViewById(R.id.buttonSalvar);
        btMasc = (RadioButton) findViewById(R.id.radioButton);
        btFem = (RadioButton) findViewById(R.id.radioButton2);

        save.setOnClickListener(botaoSalvarListener);
    }

    private View.OnClickListener botaoSalvarListener = new View.OnClickListener(){
      @Override
      public void onClick(View v){
          SharedPreferences preferences = getSharedPreferences("dados", Context.MODE_PRIVATE);
          SharedPreferences.Editor editor = preferences.edit();

          name = nome.getText().toString();
          age = Integer.parseInt(String.valueOf(idade.getText()));

          if(btMasc.isChecked()){
              genre = "Masculino";
          }else if(btFem.isChecked()){
              genre = "Feminino";
          }

          editor.putString("nome",name);
          editor.putString("sexo",genre);
          editor.putInt("idade",age);
          editor.commit();

          Intent i = new Intent();
          setResult(RESULT_OK,i);
          Modificar.this.finish();

      }
    };
}
