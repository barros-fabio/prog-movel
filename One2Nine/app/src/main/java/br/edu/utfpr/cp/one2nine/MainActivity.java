package br.edu.utfpr.cp.one2nine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btGame = (Button) findViewById(R.id.startButton);
        btGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                startActivity(i);
            }
        });

        Button btScore = (Button) findViewById(R.id.scoreButton);
        btScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EscoreActivity.class);
                startActivity(i);
            }
        });
    }
}