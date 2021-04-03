package com.example.ads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     private TextView label;
     private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label= findViewById(R.id.main_label_principal);
        editText = findViewById(R.id.main_input_name);

        label.setText("Alo, Mundo");
    }

    public void metodo(View view){
        String texto = editText.getText().toString();
        label.setText(texto);
        Toast.makeText(this,"Exercicios 1 e 2", Toast.LENGTH_LONG).show();
        Log.d("Exercicios 1 e 2","Olá, enfermeira");

    }





}