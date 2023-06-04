package item;

import java.io.File;
import java.util.ArrayList;

import usuario.Doador;

public class Item {

    private Status status;
    private int id;
    private String nome;
    private TipoItem tipo;
    private String descricao;
    private File foto;
    private String localizacao;
    private Doador doador;
    private ArrayList<Interesse> interessados;

    public Item(String nome, TipoItem tipo, String descricao, File foto, String localizacao, Doador doador){

        this.status = Status.pendente;
        this.id = 0; // Ver como faremos com o ID depois. Quem vai controlar os IDs?
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.foto = foto;
        this.localizacao = localizacao;
        this.interessados = new ArrayList<>();

    }

    //  Caso nao tenha foto
    public Item(String nome, TipoItem tipo, String descricao, String localizacao, Doador doador){

        this.status = Status.pendente;
        this.id = 0; // Ver como faremos com o ID depois. Quem vai controlar os IDs?
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.foto = null;
        this.localizacao = localizacao;
        this.interessados = new ArrayList<>();
        
    }

    public void deletar(){

    }

    public void exibir(){
        
    }

    public void interessados(){
        
    }

    public void demonstrarInteresse(Doador user, String justificativa){
        
    }

    public void doar(){
        
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

    public File getFoto() {
        return this.foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
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

    
}
