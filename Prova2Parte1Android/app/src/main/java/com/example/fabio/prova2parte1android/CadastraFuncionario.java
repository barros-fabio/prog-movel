package com.example.fabio.prova2parte1android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;

import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class CadastraFuncionario extends AppCompatActivity {
    EditText idF, nomeF, salarioF, idadeF, cargoF;
    Button btnSalvar;
    TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_funcionario);

        idF = (EditText) findViewById(R.id.idFunc);
        nomeF = (EditText) findViewById(R.id.nomeFunc);
        salarioF = (EditText) findViewById(R.id.salarioFunc);
        idadeF = (EditText) findViewById(R.id.idadeFunc);
        cargoF = (EditText) findViewById(R.id.cargoFunc);
        btnSalvar = (Button) findViewById(R.id.botaoSalvar);
        status = (TextView) findViewById(R.id.status);

        btnSalvar.setOnClickListener(botaoSalvarListener);

    }

    private View.OnClickListener botaoSalvarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if (isNetworkAvailable())
                status.setText("Conectado");
            else
                status.setText("Não conectado");

            cadastraFuncionario();


        }
    };

    public void cadastraFuncionario(){


    }




    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null
                && activeNetworkInfo.isConnectedOrConnecting();
    }
}
