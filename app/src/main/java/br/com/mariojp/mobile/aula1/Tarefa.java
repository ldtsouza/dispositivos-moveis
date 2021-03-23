package br.com.mariojp.mobile.aula1;

import java.io.Serializable;
import java.util.Objects;

public class Tarefa implements Serializable {

    private String titulo;
    private String descricao;
    private Integer prioridade;

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, Integer prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(titulo, tarefa.titulo) &&
                Objects.equals(descricao, tarefa.descricao) &&
                Objects.equals(prioridade, tarefa.prioridade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao, prioridade);
    }
}
