package cadastro;

import java.util.ArrayList;

import usuario.Doador;
import usuario.TipoDoador;

public class SistemaCadastro {

    private ArrayList<Doador> doadores;
    private Doador doadorLogado;

    public SistemaCadastro(){
        this.doadores = new ArrayList<Doador>();
    }

    public void cadastrarDoador(String nome, String email, String identificador, String telefone, String senha, TipoDoador tipoDoador){
        System.out.println(String.format("Cadastro do doador %s feito com sucesso!", nome));
        this.doadores.add(new Doador(nome, email, identificador, telefone, senha, tipoDoador));
    }

    public void login(String email, String senha){
        for (Doador doador : this.doadores)
            if (doador.getEmail().equals(email) && doador.getSenha().equals(senha)){
                System.out.println(String.format("Login do doador %s feito com sucesso!", doador.getNome()));
                this.doadorLogado = doador;
            }
        System.out.println("Dados incorretos! Não foi possível fazer login.");
    }

    public Doador doadorLogado(){
        return this.doadorLogado;
    }
    
}
