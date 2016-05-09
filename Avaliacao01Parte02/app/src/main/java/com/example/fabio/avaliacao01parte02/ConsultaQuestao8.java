package com.example.fabio.avaliacao01parte02;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConsultaQuestao8 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_questao8);
        DBHelper dbHelper = new DBHelper(ConsultaQuestao8.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
        ArrayAdapter<Pessoa> pessoasAdapter;
        ListView pessoasListView;


        Cursor cursor = db.rawQuery("SELECT * FROM Pessoa",null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            Pessoa pes = new Pessoa();
            pes.setNome(cursor.getString(1));
            pes.setSexo(cursor.getString(2));
            pes.setIdade(cursor.getInt(3));

            listaPessoas.add(pes);
            cursor.moveToNext();
        }

        pessoasAdapter = new ArrayAdapter<Pessoa>(ConsultaQuestao8.this, android.R.layout.simple_list_item_1,listaPessoas);
        pessoasListView = (ListView) findViewById(R.id.listView);
        pessoasListView.setAdapter(pessoasAdapter);

        dbHelper.close();


    }
}
