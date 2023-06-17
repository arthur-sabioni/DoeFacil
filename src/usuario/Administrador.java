package usuario;

import item.Item;
import item.Status;

public class Administrador extends Doador{

    public Administrador(String nome, String email, String identificador, String telefone, String senha, TipoDoador tipo){

        super(nome,email,identificador,telefone,senha,tipo);

    }

    public void aprovarItem(Item item){
        item.setStatus(Status.aprovado);
    }

    public void visualizarItens(){
        
    }

    @Override
    public String toString() {
        return "{Administrador: " +
            " nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", identificador='" + getIdentificador() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", senha='" + getSenha() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }
}
