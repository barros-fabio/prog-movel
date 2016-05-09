package com.example.fabio.listapersistencia;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InserirMedicao extends AppCompatActivity {
    EditText date, time, temp, umid, press;
    Button salvar;
    TextView local_med;
    int id_local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_medicao);
        id_local = Integer.parseInt(getIntent().getSerializableExtra("local").toString());


        local_med = (TextView) findViewById(R.id.textView);
        local_med.setText(id_local);

        date = (EditText) findViewById(R.id.data);
        time = (EditText) findViewById(R.id.hora);
        temp = (EditText) findViewById(R.id.temperatura);
        umid = (EditText) findViewById(R.id.umidade);
        press = (EditText) findViewById(R.id.pressao);
        salvar = (Button) findViewById(R.id.botaoSalvarMedicao);
        salvar.setOnClickListener(botaoSalvarListener);
    }

    private View.OnClickListener botaoSalvarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            DBHelper dbHelper = new DBHelper(InserirMedicao.this);
            SQLiteDatabase bd = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("data",date.getText().toString());
            values.put("hora",time.getText().toString());
            values.put("temperatura",Double.parseDouble(temp.getText().toString()));
            values.put("umidade",Double.parseDouble(umid.getText().toString()));
            values.put("pressao",Double.parseDouble(press.getText().toString()));
            values.put("localizacao",id_local);


            bd.insert("Medicao",null,values);

            dbHelper.close();

            InserirMedicao.this.finish();
        }
    };
}
