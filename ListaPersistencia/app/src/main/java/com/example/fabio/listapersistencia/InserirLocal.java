package com.example.fabio.listapersistencia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InserirLocal extends AppCompatActivity {
    EditText nome, lat, longt;
    Button salvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_local);

        nome = (EditText) findViewById(R.id.nomeLocal);
        lat = (EditText) findViewById(R.id.latitude);
        longt = (EditText) findViewById(R.id.longitude);
        salvar = (Button) findViewById(R.id.salvar);
        salvar.setOnClickListener(botaoSalvarListener);


    }

    private View.OnClickListener botaoSalvarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            DBHelper dbHelper = new DBHelper(InserirLocal.this);
            SQLiteDatabase bd = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nome",nome.getText().toString());
            values.put("latitude",lat.getText().toString());
            values.put("longitude",longt.getText().toString());

            bd.insert("Local",null,values);

            dbHelper.close();

            Intent i = new Intent();

            setResult(RESULT_OK,i);
            InserirLocal.this.finish();
        }
    };


}
