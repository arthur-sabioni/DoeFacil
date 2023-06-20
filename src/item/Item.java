package item;

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
    private String justificativaRejeicao;
    private ArrayList<Interesse> interessados;
    private Doador donatario;

    public Item(Doador doador, int id, TipoItem tipo, String nome, String descricao, String localizacao){

        this.doador = doador;
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.status = Status.pendente;
        this.justificativaRejeicao = null;
        this.interessados = new ArrayList<>();
        this.donatario = null;
    }

    public void deletar(){
        this.status = Status.deletado;
    }

    public void exibir(){
        System.out.println(this.toString());
    }

    public void demonstrarInteresse(Doador user, String justificativa){
        this.interessados.add(new Interesse(interessados.size(), user, justificativa));
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

    public String getJustificativaRejeicao() {
        return this.justificativaRejeicao;
    }

    public void setJustificativaRejeicao(String justificativaRejeicao) {
        this.justificativaRejeicao = justificativaRejeicao;
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

    public Doador getDonatario() {
        return this.donatario;
    }

    public void setDonatario(Doador donatario) {
        this.donatario = donatario;
    }

    @Override
    public String toString() {
        return "{Item: " +
            " doador='" + getDoador().getNome() + "'" +
            ", id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", localizacao='" + getLocalizacao() + "'" +
            ", status='" + getStatus() + "'" +
            ", justificativaRejeicao='" + getJustificativaRejeicao() + "'" +
            ", interessados='" + getInteressados() + "'" +
            ", donatario='" + getDonatario() + "'" +
            "}";
    }

    public String toStringDadosBasicos() {
        return "{Item: " +
            " id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", localizacao='" + getLocalizacao() + "'" +
            "}";
    }

    public String toStringDadosBasicosComDoador() {
        return "{Item: " +
            " doador='" + getDoador() + "'" +
            " id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", localizacao='" + getLocalizacao() + "'" +
            "}";
    }

    public String exibirInteresses() { 
        if(interessados.isEmpty())
            return "Não há interessados no Item " + 
            "{id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'}";

        String stringInteressados = "";
        for(Interesse interesse : interessados)
            stringInteressados += "\t- " + interesse.toString();
        
        return "Interessados no Item " + 
            "{id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'}:\n" +
            stringInteressados;
    }

}
