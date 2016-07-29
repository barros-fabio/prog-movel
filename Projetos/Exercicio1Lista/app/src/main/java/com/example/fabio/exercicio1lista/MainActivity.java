package com.example.fabio.exercicio1lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCalcular = (Button) findViewById(R.id.calcular);
        btCalcular.setOnClickListener(listener1);
    }

    private OnClickListener listener1 = new OnClickListener(){
        @Override
        public void onClick(View v) {
            double altura;
            double peso;
            double imc;

            EditText alturaEditText = (EditText) findViewById(R.id.altura);
            EditText pesoEditText = (EditText) findViewById(R.id.peso);

            altura = Double.parseDouble(alturaEditText.getText().toString());
            peso = Double.parseDouble(pesoEditText.getText().toString());

            imc= peso/(altura*altura);

            /*Builder alertDialog =  new Builder(MainActivity.this);
            alertDialog.setTitle("Resultado do cálculo do IMC");
            alertDialog.setMessage("O seu IMC é: " + imc);
            alertDialog.setPositiveButton("OK", null);
            alertDialog.show();*/

            Intent i = new Intent(MainActivity.this, MostraResultado.class);
            i.putExtra("imc",imc);
            startActivity(i);
        }
    };
}
