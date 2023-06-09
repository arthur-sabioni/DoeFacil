package cadastro;

import java.util.ArrayList;

import persistencia.PersistenciaCadastro;
import usuario.Administrador;
import usuario.Doador;
import usuario.TipoDoador;

public class SistemaCadastro {

    private ArrayList<Doador> doadores;
    private Doador doadorLogado;

    public SistemaCadastro(){
        this.doadores = PersistenciaCadastro.carregarDadosCadastro();
        if(this.doadores == null)
            this.doadores = new ArrayList<Doador>();
    }

    public boolean dadoUnicoJaExistente(String email, String identificador){
        return doadores.stream().anyMatch(doador -> (doador.getEmail().equals(email) || doador.getIdentificador().equals(identificador)));
    }

    public void cadastrarDoador(String nome, String email, String identificador, String telefone, 
                                String senha, TipoDoador tipoDoador, boolean administrador){

        if(dadoUnicoJaExistente(email, identificador)){
            System.out.println("Existem doadores já cadastrados com os dados informados!");
            return;
        }

        Doador novoDoador = null;
        if(administrador)
            novoDoador = new Administrador(nome, email, identificador, telefone, senha, tipoDoador);
        else
            novoDoador = new Doador(nome, email, identificador, telefone, senha, tipoDoador);
        this.doadores.add(novoDoador);
        System.out.println(String.format("Cadastro do doador %s feito com sucesso!", nome));
        PersistenciaCadastro.salvarDadosCadastro(this.doadores);
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

}
