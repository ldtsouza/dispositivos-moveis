package br.com.mariojp.mobile.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Usando o Log para exibir no Logcat o ciclo de vida da Activity
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    private EditText campo;

    /**
     * onCreate()
     * Sua implementação é obrigatoria
     * É chamado pelo sistema para criar a Activity
     * A Activity é criada atravez dele e para ele é passado o estado (Bundle).
     * No método onCreate(), você executa a lógica básica de inicialização da Activity.
     * Isso deve acontecer somente uma vez durante todo o período que a Activity durar.
     * Boas praticas para sua implementação:
     * - vincular dados a listas
     * - associar a atividade a um ViewModel
     * - instanciar algumas variáveis com escopo de classe
     * Esse método recebe um parâmetro do tipo Bundle que contém o estado anteriormente salvo da Activity.
     * - Se a atividade nunca existiu, o valor do objeto Bundle será nulo.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Principal");

        Log.d("Ciclo de Vida","Ciclo de Vida - onCreate");
        campo = findViewById(R.id.main_edit_texto);
    }




    public void enviar(View view) {
        //Intent Explicita
        Intent intent = new Intent(this,SegundaActivity.class);
        intent.putExtra("CHAVE", campo.getText().toString() );
        startActivity(intent);
    }
}