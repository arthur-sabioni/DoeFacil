package interfaces;

import item.Item;
import usuario.Administrador;

public class InterfaceAdministrador extends InterfaceDoador {

    private Administrador user;

    public InterfaceAdministrador(Administrador user){
        super(user);
        this.user = user;
    }

    public void mostrarOpcoes(){
        
    }

    public void administrarItens(){

    }

    public void reprovarItem(){

    }

    public void aprovarItem(Item item){
    }

}
