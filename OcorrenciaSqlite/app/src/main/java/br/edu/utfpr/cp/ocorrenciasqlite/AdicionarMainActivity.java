package br.edu.utfpr.cp.ocorrenciasqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdicionarMainActivity extends AppCompatActivity {
    EditText nomeET, descET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_main);

        nomeET = (EditText) findViewById(R.id.nomeEditText);
        descET = (EditText) findViewById(R.id.descEditText);
        Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(bt1Listener);
    }

    private View.OnClickListener bt1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nome = nomeET.getText().toString();
            String descricao = descET.getText().toString();

            //inserir no bd
            DBHelper dbHelper = new DBHelper(AdicionarMainActivity.this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put("nome", nome);
            valores.put("descricao", descricao);
            String horarioAtual = SimpleDateFormat.getDateTimeInstance().format(new Date());
            valores.put("horarioregistro", horarioAtual);
            long idGerado = db.insert("ocorrencia", null, valores);
            dbHelper.close();

            Toast.makeText(AdicionarMainActivity.this, "Ocorrência salva, Id: " + idGerado, Toast.LENGTH_LONG).show();
            AdicionarMainActivity.this.finish();
        }
    };
}
