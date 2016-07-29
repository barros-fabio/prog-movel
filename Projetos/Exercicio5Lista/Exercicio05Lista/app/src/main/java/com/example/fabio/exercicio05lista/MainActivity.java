package com.example.fabio.exercicio05lista;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    Spinner state;
    Spinner city;
    ArrayList<String> estado = new ArrayList<>();
    ArrayList<String> cidades = new ArrayList<>();
    ArrayAdapter<String> estadoAdapter;
    ArrayAdapter<String> cidadesAdapter;
    Pessoa p = new Pessoa();
    Cidade c = new Cidade();
    RadioButton bt0, bt1;
    int genero;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nomeET = (EditText) findViewById(R.id.nome);


        estado.add("Paraná");
        estado.add("São Paulo");
        estado.add("Santa Catarina");

        bt0 = (RadioButton) findViewById(R.id.radioButtonMasc);
        bt1 = (RadioButton) findViewById(R.id.radioButtonFem);
        bt0.setOnClickListener(onRadioClickListener);
        bt1.setOnClickListener(onRadioClickListener);

        state = (Spinner) findViewById(R.id.estado);
        estadoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, estado);
        state.setAdapter(estadoAdapter);
        state.setOnItemSelectedListener(onItemSelectedEstadoListener);

        city = (Spinner) findViewById(R.id.cidade);
        cidadesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cidades);
        city.setAdapter(cidadesAdapter);


        salvar = (Button) findViewById(R.id.salvar);
        salvar.setOnClickListener(onBotaoSalvarClickListener);
    }

    private OnClickListener onRadioClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean checked = ((RadioButton) v).isChecked();

            if(checked) {
                switch ( v.getId() ) {
                    case R.id.radioButtonMasc:
                        genero = 0;
                        break;
                    case R.id.radioButtonFem:
                        genero = 1;
                        break;
                }
            }
        }
    };

    private AdapterView.OnItemSelectedListener onItemSelectedEstadoListener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            cidades.clear();
            ArrayList<String> retCidades = c.getCidadeByEstado(state.getSelectedItem().toString());
            cidades.addAll(retCidades);
            cidadesAdapter.notifyDataSetChanged();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // TODO Auto-generated method stub

        }

    };

    private OnClickListener onBotaoSalvarClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, Informacoes.class);
            i.putExtra("info",p);
            startActivity(i);
        }
    };



}
