package br.edu.utfpr.cp.one2nine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NomeRecorde extends AppCompatActivity {
    EditText name;
    Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_recorde);

        name = (EditText) findViewById(R.id.recordista);
        saveButton = (Button) findViewById(R.id.btSave);
        saveButton.setOnClickListener(btSalvarListener);

    }

    private View.OnClickListener btSalvarListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent();
            i.putExtra("nomeRecordista",name.getText().toString());
            setResult(RESULT_OK,i);
            NomeRecorde.this.finish();
        }

    };


}
