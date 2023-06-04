package usuario;

import item.Item;

public class Administrador extends Doador{

    public Administrador(String nome, String email, String identificador, String telefone, String senha, TipoDoador tipo){

        super(nome,email,identificador,telefone,senha,tipo);

    }

    public void aprovarItem(Item item){

    }

    public void visualizarItens(){
        
    }
    
}
