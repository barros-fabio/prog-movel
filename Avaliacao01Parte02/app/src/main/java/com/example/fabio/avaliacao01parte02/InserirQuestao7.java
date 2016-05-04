package com.example.fabio.avaliacao01parte02;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class InserirQuestao7 extends AppCompatActivity {
    private EditText name, age;
    private RadioButton mRB, fRB;
    private String genre;
    Button salvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_questao7);

        name = (EditText) findViewById(R.id.nome);
        age = (EditText) findViewById(R.id.idade);
        mRB = (RadioButton) findViewById(R.id.mascRB);
        fRB = (RadioButton) findViewById(R.id.femRB);
        salvar = (Button) findViewById(R.id.buttonSalvar);

        if(mRB.isChecked()){
            genre = "Masculino";
        }else if(fRB.isChecked()){
            genre = "Feminino";
        }

        salvar.setOnClickListener(btSalvarListener);
    }

    private View.OnClickListener btSalvarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DBHelper dbHelper = new DBHelper(InserirQuestao7.this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nome",name.getText().toString());
            values.put("idade",Integer.parseInt(age.getText().toString()));
            values.put("sexo",genre);

            db.insert("Pessoa",null,values);


            dbHelper.close();

            Intent i = new Intent();

            setResult(RESULT_OK, i);
            InserirQuestao7.this.finish();
        }
    };


}
