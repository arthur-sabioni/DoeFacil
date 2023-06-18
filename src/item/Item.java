package item;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import usuario.Doador;

public class Item implements Serializable{

    private Doador doador;
    private int id;
    private TipoItem tipo;
    private String nome;
    private String descricao;
    private String localizacao;
    private Status status;
    private ArrayList<Interesse> interessados;

    public Item(int id, String nome, TipoItem tipo, String descricao, File foto, String localizacao, Doador doador){

        this.status = Status.pendente;
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.interessados = new ArrayList<>();

    }

    public void deletar(){
        this.status = Status.deletado;
    }

    public void exibir(){
        System.out.println(this.toString());
    }

    public boolean demonstrarInteresse(Doador user, String justificativa){
        return this.interessados.add(new Interesse(user, justificativa));
    }

    public void doar(){
        this.status = Status.doado;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoItem getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Doador getDoador() {
        return this.doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public ArrayList<Interesse> getInteressados() {
        return this.interessados;
    }


    @Override
    public String toString() {
        return "{Item: " +
            " doador='" + getDoador() + "'" +
            ", id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", localizacao='" + getLocalizacao() + "'" +
            ", status='" + getStatus() + "'" +
            ", interessados='" + getInteressados() + "'" +
            "}";
    }

    public String toStringSemDoador() {
        return "{Item: " +
            " id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", localizacao='" + getLocalizacao() + "'" +
            ", status='" + getStatus() + "'" +
            ", interessados='" + getInteressados() + "'" +
            "}";
    }

}
