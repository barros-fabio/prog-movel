package com.example.fabio.prova2pt1;

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
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.Header;
import java.text.DecimalFormat;

public class PesquisaTarefa extends AppCompatActivity {
    EditText pesquisarTarefa;
    Button pesquisa;
    TextView tarefa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_tarefa);

        pesquisarTarefa = (EditText) findViewById(R.id.pesquisa);
        pesquisa = (Button) findViewById(R.id.botaoPesquisa);
        tarefa = (TextView) findViewById(R.id.tarefa);

        pesquisa.setOnClickListener(botaoPesquisarListener);

    }

    private View.OnClickListener botaoPesquisarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if (isNetworkAvailable())
                tarefa.setText("Conectado");
            else
                tarefa.setText("Não conectado");

            pesquisaTarefa();


        }
    };

    private void pesquisaTarefa() {
        //create an account in https://home.openweathermap.org/users/sign_in
        //you will get and appid (fill it below)
        //String appid = "cb8b448c4be7e3af4269eed911330fd4";
        String resourceURL = "http://localhost:4000/task";
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get(resourceURL, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                String nome = "";

                for(int i = 0; i<jsonArray.length();i++){
                    try {
                        //see http://openweathermap.org/weather-data#current
                        //for the JSON file format
                        JSONObject obj = jsonArray.getJSONObject(i);
                        if(obj.getInt("id")==Integer.parseInt(pesquisa.getText().toString())){
                            nome = obj.getString("nome");
                        }


                    } catch (JSONException e) {
                        nome = "Erro ao analisar o arquivo json.";
                    }
                }
                tarefa.setText(nome);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                tarefa.setText("Erro ao acessar o serviço");
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
