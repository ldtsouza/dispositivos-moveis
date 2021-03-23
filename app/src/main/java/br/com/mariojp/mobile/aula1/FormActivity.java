package br.com.mariojp.mobile.aula1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class FormActivity extends AppCompatActivity {

    private TextInputEditText titulo;

    private TextInputEditText descricao;

    private TextInputEditText prioridade;

    private Tarefa tarefa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        titulo = findViewById(R.id.form_text_titulo);
        descricao= findViewById(R.id.form_text_descricao);
        prioridade= findViewById(R.id.form_text_prioridade);

        Intent intent = getIntent();
        if( intent.hasExtra("TAREFA")){
            setTitle("Alterar Tarefa");
            tarefa = (Tarefa) intent.getSerializableExtra("TAREFA");
            titulo.setText(tarefa.getTitulo());
            descricao.setText(tarefa.getDescricao());
            prioridade.setText(tarefa.getPrioridade()+"");
        }else {
            setTitle("Nova Tarefa");
            tarefa = new Tarefa();
        }





    }

    public void salvar(View view){
        if(!MainActivity.tarefas.contains(tarefa)) {
            MainActivity.tarefas.add(tarefa);
        }else {
            int index = MainActivity.tarefas.indexOf(tarefa);
            tarefa = MainActivity.tarefas.get(index);
        }
        tarefa.setTitulo(titulo.getText().toString());
        tarefa.setDescricao(descricao.getText().toString());
        tarefa.setPrioridade(Integer.parseInt(prioridade.getText().toString()));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_form,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_form_salvar:
                salvar(item.getActionView());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
