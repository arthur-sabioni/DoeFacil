package interfaces;

import email.Mailer;
import item.Item;
import item.ItemBag;
import usuario.Doador;

public class InterfaceDoador implements Interface {

    protected ItemBag itemBag;
    protected Mailer mailer;
    protected Doador user;

    public InterfaceDoador(Doador user) {

        this.itemBag = new ItemBag();
        this.mailer = new Mailer();
        this.user = user;

    }

    public void mostrarOpcoes(){
        
    }

    public void cadastrarNovoItem(){

    }

    public void deletarItem(){
        
    }

    public void editarItem(){
        
    }

    public void aprovarInteresses(){
        
    }

    public void buscarItens(){
        
    }

    public void demonstrarInteresse(Item item){
        
    }
    
}
