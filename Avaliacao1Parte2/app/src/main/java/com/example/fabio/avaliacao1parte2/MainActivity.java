package com.example.fabio.avaliacao1parte2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView2, textView4, textView6;
    Button buttonModificar;
    private final int TASK_ADD_CODE = 23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("dados", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        // adicionando dados
/*        editor.putString("nome","Fabio");
        editor.putString("sexo","Masculino");
        editor.putInt("idade",22);
        editor.commit();

*/
        textView2 = (TextView) findViewById(R.id.textView2);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView6 = (TextView) findViewById(R.id.textView6);
        buttonModificar = (Button) findViewById(R.id.buttonModificar);


        //recuperando os dados salvos e mostrando
        textView2.setText(preferences.getString("nome","Sem nome"));
        textView4.setText(preferences.getString("sexo","Não informado"));

        int age = preferences.getInt("idade",0);
        textView6.setText(Integer.toString(age));

        buttonModificar.setOnClickListener(buttonModificarListener);

    }

    private View.OnClickListener buttonModificarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(MainActivity.this, Modificar.class );
            startActivityForResult(i, TASK_ADD_CODE);
        }

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == TASK_ADD_CODE && resultCode == RESULT_OK){
            SharedPreferences preferences = getSharedPreferences("dados", Context.MODE_PRIVATE);

            textView2.setText(preferences.getString("nome","Sem nome"));
            textView4.setText(preferences.getString("sexo","Não informado"));

            int age = preferences.getInt("idade",0);
            textView6.setText(Integer.toString(age));

        }
    }
}
