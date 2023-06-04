package interfaces;

import cadastro.SistemaCadastro;
import usuario.Doador;

public class InterfaceCadastro implements Interface{

    private SistemaCadastro sistema;

    public InterfaceCadastro(){

        this.sistema = new SistemaCadastro();

    }

    public void mostrarOpcoes(){
        
    }


    public Doador realizarLogin(){
        return null;
    }

    public void realizarCadastro(){

    }
    
}
