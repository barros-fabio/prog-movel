package com.example.fabio.exercicio2lista;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by fabio on 4/2/16.
 */
public class Adicionar extends Activity implements Serializable{

    EditText editAdicionar;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar);

        editAdicionar = (EditText) findViewById(R.id.novoRegistro);



        Button bt1 = (Button) findViewById(R.id.addButton);
        bt1.setOnClickListener(listener1);
    }

    private OnClickListener listener1 = new OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            i.putExtra("serie", editAdicionar.getText().toString());
            setResult(RESULT_OK, i);
            Adicionar.this.finish();
        }
    };


}
