package br.edu.utfpr.cp.ocorrenciasqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(bt1Listener);
    }

    private View.OnClickListener bt1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, AdicionarMainActivity.class);
            startActivity(i);
        }
    };
}
