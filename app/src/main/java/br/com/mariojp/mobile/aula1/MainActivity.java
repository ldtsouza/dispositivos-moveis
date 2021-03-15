package br.com.mariojp.mobile.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Usando o Log para exibir no Logcat o ciclo de vida da Activity
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {


    private TextView label;
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
        Log.d("Ciclo de Vida","Ciclo de Vida - onCreate");

        label = findViewById(R.id.main_label_text);
        campo = findViewById(R.id.main_edit_text);

        Button alterar2 = findViewById(R.id.main_botao_alterar2);
        alterar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = campo.getText().toString();
                label.setText(texto);
                Toast.makeText(MainActivity.this,"Botao de Alterar 2 texto: "+ texto,Toast.LENGTH_LONG).show();
                Log.d("Botao de Alterar 2", "Texto: "+ texto);
            }
        });

    }


    /**
     * metodo do botao alterar 1
     * Executado pelo propriedade onclick:
     * android:onClick="alterar"
     * @param view
     */
    public void alterar(View view) {
        String texto = campo.getText().toString();
        label.setText(texto);
        Toast.makeText(this,"Botao de Alterar 1 texto: "+ texto,Toast.LENGTH_LONG).show();
        Log.d("Botao de Alterar 1", "Texto: "+ texto);
    }
}