package com.example.fabio.exercicio1lista;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by fabio on 4/1/16.
 */
public class MostraResultado extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostra_resultado);
        Double imcRes = getIntent().getDoubleExtra("imc", 0.0);
        TextView resultado = (TextView) findViewById(R.id.resultado);
        TextView recomend = (TextView) findViewById(R.id.recomendacao);
        resultado.setText("O resultado do seu IMC é: "+imcRes);

        if(imcRes<17){
            recomend.setText("Muito abaixo do peso");
        }else if(imcRes>=17 && imcRes<18.49){
            recomend.setText("Abaixo do peso");
        }else if(imcRes>=18.49 && imcRes<24.99){
            recomend.setText("Peso normal");
        }else if(imcRes>=25 && imcRes<29.99){
            recomend.setText("Acima do peso");
        }else if(imcRes>=30 && imcRes<34.99){
            recomend.setText("Obesidade I");
        }else if(imcRes>=35 && imcRes<39.99){
            recomend.setText("Obesidade II(severa)");
        }else{
            recomend.setText("Obesidade III(mórbida)");
        }
    }


}
