package com.example.ads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

     private TextView label;
     private EditText texto;
     private  FloatingActionButton botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ATIVIDADE","OnCreate");

        texto = findViewById(R.id.EditText);
        label= findViewById(R.id.main_label_principal);
        botao = findViewById(R.id.main_botao_segunda);

        label.setText("Alo, Mundo");

            botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviaTexto();

            }
        });

        }

      private void enviaTela2(){
          Intent segunda = new Intent (this,SegundaActivity.class);
          segunda.putExtra(SegundaActivity.ACTIVITY_CHAVE_LABEL,"vamos para segunda tela");
          startActivity(segunda);

      }

    private void enviaTexto() {
        //implicita
        Intent enviar = new Intent(Intent.ACTION_SEND);
        enviaTexto.setType("text/plain");
        enviaTexto.putExtra(Intent.EXTRA_TEXT, texto.getText().toString());
        startActivity(enviaTexto);
    }

         public void metodo (View view){
         String texto = texto.getText().toString();
          label.setText(texto);
         Toast.makeText(this,"ATIVIDADE", Toast.LENGTH_LONG).show();
         Log.d("ATIVIDADE","Olá, enfermeira");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ATIVIDADE","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ATIVIDADE","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ATIVIDADE","OnPause");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ATIVIDADE","OnRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Stop
        Log.d("ATIVIDADE","OnStop");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ATIVIDADE","OnDestroy");
    }


}