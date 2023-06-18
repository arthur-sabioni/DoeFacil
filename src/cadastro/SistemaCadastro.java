package cadastro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import usuario.Administrador;
import usuario.Doador;
import usuario.TipoDoador;
import util.ArquivoUtil;

public class SistemaCadastro {

    private static String ARQUIVO_DADOS = "dadosCadastro.dat";
    private ArrayList<Doador> doadores;
    private Doador doadorLogado;

    public SistemaCadastro(){
        this.doadores = carregarDadosCadastro();
        if(this.doadores == null)
            this.doadores = new ArrayList<Doador>();
    }

    public void cadastrarDoador(String nome, String email, String identificador, String telefone, 
                                String senha, TipoDoador tipoDoador, boolean administrador){
        System.out.println(String.format("Cadastro do doador %s feito com sucesso!", nome));
        Doador novoDoador = null;
        if(administrador)
            novoDoador = new Administrador(nome, email, identificador, telefone, senha, tipoDoador);
        else
            novoDoador = new Doador(nome, email, identificador, telefone, senha, tipoDoador);
        this.doadores.add(novoDoador);
        this.salvarDadosCadastro();
    }

    public void login(String email, String senha){
        for (Doador doador : this.doadores)
            if (doador.getEmail().equals(email) && doador.getSenha().equals(senha)){
                System.out.println(String.format("Login do doador %s feito com sucesso!", doador.getNome()));
                this.doadorLogado = doador;
                return;
            }
        System.out.println("Dados incorretos! Não foi possível fazer login.");
    }

    public Doador doadorLogado(){
        return this.doadorLogado;
    }

    public void salvarDadosCadastro(){
        ObjectOutputStream oos = ArquivoUtil.abrirArquivoParaEscrita(ARQUIVO_DADOS);
        try {
            oos.writeObject(this.doadores);
            oos.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados de cadastro.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Doador> carregarDadosCadastro(){
        ArrayList<Doador> doadores = null;
        try {
            ObjectInputStream ois = ArquivoUtil.abrirArquivoParaLeitura(ARQUIVO_DADOS);
            doadores = (ArrayList<Doador>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erro ao carregar os dados de cadastro, será inicializado um cadastro vazio.");
        }
        return doadores;
    }

}
