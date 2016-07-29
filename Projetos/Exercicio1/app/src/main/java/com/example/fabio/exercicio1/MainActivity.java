package com.example.fabio.exercicio1;


import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.app.AlertDialog.Builder;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(listener1);

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(listener2);

        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(listener3);

    }

    private OnClickListener listener1 = new OnClickListener(){
        @Override
        public void onClick(View v){
            EditText editText1 = (EditText) findViewById(R.id.editText);
            String str = editText1.getText().toString();
            if(str.equals("")){
                Builder alertDialogBuilder = new Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Erro");
                alertDialogBuilder.setMessage("Campo vazio! Preencha o campo!");
                alertDialogBuilder.setPositiveButton("OK",null);
                alertDialogBuilder.show();
            }else{
                TextView textView1 = (TextView) findViewById(R.id.textView);
                textView1.setText(str);
                editText1.setText("");
            }

        }
    };

    private OnClickListener listener2 = new OnClickListener(){
        @Override
        public void onClick(View v){
            EditText editText1 = (EditText) findViewById(R.id.editText);
            String str = editText1.getText().toString();
            if(str.equals("")){
                Builder alertDialogBuilder = new Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Erro");
                alertDialogBuilder.setMessage("Campo vazio! Preencha o campo!");
                alertDialogBuilder.setPositiveButton("OK", null);
                alertDialogBuilder.show();

            }else{
                Toast toast = Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast.show();
                editText1.setText("");
            }
        }
    };

    private OnClickListener listener3 = new OnClickListener(){
        @Override
        public void onClick(View v){
            EditText editText1 = (EditText) findViewById(R.id.editText);
            String str = editText1.getText().toString();
            Builder alertDialogBuilder = new Builder(MainActivity.this);
            if(str.equals("")){

                alertDialogBuilder.setTitle("Erro");
                alertDialogBuilder.setMessage("Campo vazio! Preencha o campo!");
                alertDialogBuilder.setPositiveButton("OK",null);
                alertDialogBuilder.show();
            }else{
                alertDialogBuilder.setMessage(str);
                alertDialogBuilder.show();
                editText1.setText("");
            }
        }
    };
}
