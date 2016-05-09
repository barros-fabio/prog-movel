package br.edu.utfpr.cp.one2nine;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.utfpr.cp.one2nine.game.*;
import br.edu.utfpr.cp.one2nine.game.Number;

public class GameActivity extends AppCompatActivity {

    ArrayList<Button> buttons = new ArrayList<Button>();
    GameConfig gameConfig = new GameConfig();
    List<br.edu.utfpr.cp.one2nine.game.Number> currentListOfNumbers;
    int nextNumberMustBe;
    long startTime;
    private final int TASK_ADD_CODE = 23;
    String nome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        retrieveButtons();

        startNewRound();
        startTime = System.currentTimeMillis();
    }

    /**
     * Recupera todos os botoes e armazena em um arraylist
     *
     * todos os botoes sao associados ao mesmo listener
     */
    private void retrieveButtons() {
        Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(btClickListener);
        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(btClickListener);
        Button bt3 = (Button) findViewById(R.id.button3);
        bt3.setOnClickListener(btClickListener);
        Button bt4 = (Button) findViewById(R.id.button4);
        bt4.setOnClickListener(btClickListener);
        Button bt5 = (Button) findViewById(R.id.button5);
        bt5.setOnClickListener(btClickListener);
        Button bt6 = (Button) findViewById(R.id.button6);
        bt6.setOnClickListener(btClickListener);
        Button bt7 = (Button) findViewById(R.id.button7);
        bt7.setOnClickListener(btClickListener);
        Button bt8 = (Button) findViewById(R.id.button8);
        bt8.setOnClickListener(btClickListener);
        Button bt9 = (Button) findViewById(R.id.button9);
        bt9.setOnClickListener(btClickListener);
        buttons.add(bt1);
        buttons.add(bt2);
        buttons.add(bt3);
        buttons.add(bt4);
        buttons.add(bt5);
        buttons.add(bt6);
        buttons.add(bt7);
        buttons.add(bt8);
        buttons.add(bt9);
    }

    /**
     *  inicia uma nova jogada
     */
    private void startNewRound() {
        currentListOfNumbers = gameConfig.getNextConfiguration();
        for (int i = 0; i < buttons.size(); i++) {
            Button bt = buttons.get(i);
            bt.setBackgroundResource(android.R.color.background_light);
            bt.setText( currentListOfNumbers.get(i).getLabel() );
        }

        nextNumberMustBe = 1;
    }

    /**
     * verifica se o jogador acertou o botao
     */
    private View.OnClickListener btClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //idenfica o botao que foi clicado
            int clickedButton = 0;
            for (int i = 0; i < buttons.size(); i++) {
                Button bt = buttons.get(i);
                if(v.getId() == bt.getId()) {
                    clickedButton = i;
                    break;
                }
            }

            //check value
            Number number = currentListOfNumbers.get(clickedButton);
            Button btCurrent = buttons.get(clickedButton);
            if(number.getValue() == nextNumberMustBe) {
                btCurrent.setBackgroundResource(android.R.color.holo_blue_light);
                nextNumberMustBe++;
            }

            //clicou nos 9 botoes, terminou a fase
            if(nextNumberMustBe == 10) {
                checkEnd();
            }
        }
    };

    /**
     * verifica se tem uma nova fase, chamando-a
     * caso contrario, termina a jogada
     */
    private void checkEnd() {
        if(gameConfig.hasNext()) {
            startNewRound();
        }
        else {
            endGame();
        }
    }

    /**
     * chamado quando terminar a jogada
     */
    private void endGame() {
        long endTime = System.currentTimeMillis();
        float yourTime = (endTime - startTime) / 1000.0f;

        String msg = "Your time was " + yourTime + " seconds.";

        //verify if it is a new high score
        SharedPreferences myPreferences = getSharedPreferences("One2NinePrefs", Context.MODE_PRIVATE);
        float bestTime = myPreferences.getFloat("time", Float.MAX_VALUE);


        if(yourTime < bestTime) {	//update best score
            Intent i = new Intent(GameActivity.this, NomeRecorde.class);
            startActivity(i,TASK_ADD_CODE);

            SharedPreferences.Editor editor = myPreferences.edit();

        }

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(GameActivity.this);
        alertBuilder.setTitle("End of the game");
        alertBuilder.setMessage(msg);
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                GameActivity.this.finish();
            }
        });

        alertBuilder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == TASK_ADD_CODE && resultCode == RESULT_OK){
            String nome = (String) data.getSerializableExtra("nomeRecordista");
        }
    }
}