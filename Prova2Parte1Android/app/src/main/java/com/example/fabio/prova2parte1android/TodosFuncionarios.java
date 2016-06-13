package com.example.fabio.prova2parte1android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TodosFuncionarios extends AppCompatActivity {

    String func;
    ArrayList<String> listaFuncionario = new ArrayList<String>();
    ArrayAdapter<String> funcionariosAdapter;
    ListView funcionariosListView;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_funcionarios);
        status = (TextView) findViewById(R.id.connStatus);

        if (isNetworkAvailable())
            status.setText("Conectado");
        else
            status.setText("Não conectado");

        buscaTodosFuncionarios();


        funcionariosAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaFuncionario);
        funcionariosListView = (ListView) findViewById(R.id.listView);
        funcionariosListView.setAdapter(funcionariosAdapter);
    }

    private void buscaTodosFuncionarios() {

        String resourceURL = "http://10.0.2.2/funcionario";
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get(resourceURL, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                String nome = "";

                for(int i = 0; i<jsonArray.length();i++){
                    try {

                        JSONObject obj = jsonArray.getJSONObject(i);
                        nome = obj.getString("nome");

                        listaFuncionario.add(nome);

                    } catch (JSONException e) {
                        nome = "Erro ao analisar o arquivo json.";
                    }
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                status.setText("Erro ao acessar o serviço");
            }
        });

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null
                && activeNetworkInfo.isConnectedOrConnecting();
    }
}
