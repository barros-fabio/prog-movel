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
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class ConsultaFuncionario extends AppCompatActivity {
    TextView resultado;
    EditText consulta;
    Button pesquisar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_funcionario);

        consulta = (EditText) findViewById(R.id.consultar);
        pesquisar = (Button) findViewById(R.id.botaoPesquisar);
        resultado = (TextView) findViewById(R.id.funcResultado);

        pesquisar.setOnClickListener(botaoPesquisarListener);


    }

    private View.OnClickListener botaoPesquisarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if (isNetworkAvailable())
                resultado.setText("Conectado");
            else
                resultado.setText("Não conectado");

            pesquisaFuncionario();


        }
    };

    private void pesquisaFuncionario() {

        String resourceURL = "http://10.0.2.2/funcionario/";
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get(resourceURL, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                String nome = "";

                for(int i = 0; i<jsonArray.length();i++){
                    try {

                        JSONObject obj = jsonArray.getJSONObject(i);
                        if(obj.getInt("id")==Integer.parseInt(consulta.getText().toString())){
                            nome = obj.getString("nome");
                        }


                    } catch (JSONException e) {
                        nome = "Erro ao analisar o arquivo json.";
                    }
                }
                resultado.setText(nome);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                resultado.setText("Erro ao acessar o serviço");
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
