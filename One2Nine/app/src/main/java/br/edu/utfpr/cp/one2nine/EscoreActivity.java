package br.edu.utfpr.cp.one2nine;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class EscoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escore);

        //retrieving persisted preferences
        SharedPreferences myPreferences = getSharedPreferences("One2NinePrefs", Context.MODE_PRIVATE);
        float bestTime = myPreferences.getFloat("time", 0);
        String playedBy = myPreferences.getString("playedBy", "No one played before.");
        String playedIn = myPreferences.getString("playedIn", "");

        TextView bestTimeTV = (TextView) findViewById(R.id.bestTimeTextView);
        DecimalFormat df = new DecimalFormat("#.00");
        bestTimeTV.setText(df.format(bestTime));
        TextView pByTV = (TextView) findViewById(R.id.playedByTextView);
        pByTV.setText(playedBy + "\n" + playedIn);
    }
}
