package cadastro;

import java.util.ArrayList;

import usuario.Doador;

public class SistemaCadastro {

    private ArrayList<Doador> doadores;

    public SistemaCadastro(){
        this.doadores = new ArrayList<Doador>();
    }

    public Boolean cadastrarDoador(Doador novoDoador){
        return true;
    }

    public Doador login(String email, String senha){
        return null;
    }
    
}
