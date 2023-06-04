package interfaces;

import email.Mailer;
import item.Item;
import item.ItemBag;
import usuario.Doador;

public class InterfaceDoador implements Interface {

    private ItemBag itens;
    private Mailer mailer;
    private Doador user;

    public InterfaceDoador(Doador user) {

        this.itens = new ItemBag();
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
