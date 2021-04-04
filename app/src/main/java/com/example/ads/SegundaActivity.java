package com.example.ads;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {

    private TextView label;
    public static final String ACTIVITY_CHAVE_LABEL  = "CHAVE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

       label = findViewById(R.id.segunda_label_text);


       // testando se a chave existe
        if (getIntent().hasExtra(ACTIVITY_CHAVE_LABEL)) {

            String dados = getIntent().getStringExtra(ACTIVITY_CHAVE_LABEL);

            label.setText(dados);
        } else {
            String dados = getIntent().getStringExtra((Intent.EXTRA_TEXT));
            label.setText(dados);
        }



    }
}