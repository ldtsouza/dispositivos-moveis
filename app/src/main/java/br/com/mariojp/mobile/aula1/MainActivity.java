package br.com.mariojp.mobile.aula1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Usando o Log para exibir no Logcat o ciclo de vida da Activity
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {
    public static ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();

    private ListView lista;
    private TarefaAdapter adapter;
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
        setTitle("Tarefas");
        Log.d("Ciclo de Vida","Ciclo de Vida - onCreate");

        //List<String> tarefas = new ArrayList<>(Arrays.asList("DEVER DE CASA", "ASSITIR AULA", "TOMAR BANHO",
        //        "LER UM LIVRO"));
        // ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , tarefas);
       tarefas.addAll(
                Arrays.asList(
                        new Tarefa("DEVER DE CASA","DESCRICAO !", 1),
                        new Tarefa("ASSITIR AULA", "DESCRICAO !", 2),
                        new Tarefa( "TOMAR BANHO","DESCRICAO !",1),
                        new Tarefa("LER UM LIVRO", "DESCRICAO !", 3)
                )
                );

        lista = findViewById(R.id.main_list_tarefas);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long l) {
                Tarefa tarefa = (Tarefa)adapter.getItemAtPosition(posicao);
                Toast.makeText(MainActivity.this,
                        "Item "+tarefa.getTitulo(),
                        Toast.LENGTH_SHORT).show();
                //Alterar
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                intent.putExtra("TAREFA",tarefa);
                startActivity(intent);
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long l) {
                Tarefa tarefa = (Tarefa)adapter.getItemAtPosition(posicao);
                Toast.makeText(MainActivity.this,
                        "Item Long"+tarefa.getTitulo(),
                        Toast.LENGTH_SHORT).show();
                //Excluir
               return false;
            }
        });

        registerForContextMenu(lista);

    }


    @Override
    protected void onResume() {
        super.onResume();
        adapter = new TarefaAdapter(this, new ArrayList<>(tarefas));
        lista.setAdapter(adapter);
    }

    public void formulario(View view){
        //Toast.makeText(this,"Vai para o form", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_form,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.menu_form_salvar:
                Toast.makeText(this,
                        this.adapter.getItem(info.position).getTitulo()
                        ,Toast.LENGTH_SHORT).show();
        }


        return super.onContextItemSelected(item);
    }
}