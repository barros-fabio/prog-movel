package com.example.fabio.listapersistencia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button insert;
    ListView list;
    ArrayList<String> locais = new ArrayList<>();
    ArrayAdapter<String> locaisAdapter;
    private final int TASK_ADD_CODE = 23;
    private ActionMode currentActionMode;
    int currentPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Local l = new Local();
        DBHelper dbHelper = new DBHelper(MainActivity.this);
        SQLiteDatabase bd = dbHelper.getWritableDatabase();

        insert = (Button) findViewById(R.id.buttonInserir);
        insert.setOnClickListener(buttonInserirListener);

           Cursor cursor = bd.rawQuery("SELECT * FROM local", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            String localizacao = cursor.getString(1);
            String latitude_l = cursor.getString(2);
            String longitude_l = cursor.getString(3);


            locais.add(localizacao);

            cursor.moveToNext();
        }

        locaisAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,locais);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(locaisAdapter);

        list.setOnItemLongClickListener(onItemLongClickListener);
    }

    // Listener do botao para Inserir
    private View.OnClickListener buttonInserirListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent(MainActivity.this, InserirLocal.class);
            startActivityForResult(i,TASK_ADD_CODE);
        }
    };


    // Listener do Botao do Menu
    private AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener(){
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
            if(currentActionMode!=null)
                return false;
            currentPosition = position;
            currentActionMode = startActionMode(modeCallBack);
            view.setSelected(true);
            return false;
        }
    };

    // Controle do Menu de Contexto
    private ActionMode.Callback modeCallBack = new ActionMode.Callback(){
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu){
            mode.setTitle("Ações");
            mode.getMenuInflater().inflate(R.menu.context_menu,menu);
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item){
            switch (item.getItemId()){
                case R.id.inserirMedicao:
                    Intent i = new Intent(MainActivity.this, InserirMedicao.class);
                    i.putExtra("local",locais.get(currentPosition));
                    startActivity(i);
            }
            return false;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu){
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode){

            currentActionMode = null;
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==TASK_ADD_CODE && resultCode == RESULT_OK){
            DBHelper dbHelper = new DBHelper(MainActivity.this);
            SQLiteDatabase bd = dbHelper.getWritableDatabase();
            Local l = new Local();
            locais.clear();
            Cursor cursor = bd.rawQuery("SELECT * FROM Local", null);
            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                String localizacao = cursor.getString(1);
                String latitude_l = cursor.getString(2);
                String longitude_l = cursor.getString(3);

                locais.add(localizacao);

                cursor.moveToNext();
            }

            //locaisAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,locais);
            //list = (ListView) findViewById(R.id.listView);
            //list.setAdapter(locaisAdapter);
            locaisAdapter.notifyDataSetChanged();
        }
    }
}
