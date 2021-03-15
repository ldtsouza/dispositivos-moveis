package br.com.mariojp.mobile.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        setTitle("Segunda");

        label = findViewById(R.id.segunda_label_texto);

        if(getIntent().hasExtra("CHAVE")){
            String texto = getIntent().getStringExtra("CHAVE");
            label.setText(texto);
        }

    }

    public void compartilhar(View view) {
        //intent implicita
        String texto = label.getText().toString();
        Intent share = new Intent(Intent.ACTION_SEND);
        share.putExtra(Intent.EXTRA_TEXT, texto);
        share.setType("text/plain");

        // Verify se o antroid pode resolver essa intent
        if (share.resolveActivity(getPackageManager()) != null) {
            startActivity(share);
        }    }
}