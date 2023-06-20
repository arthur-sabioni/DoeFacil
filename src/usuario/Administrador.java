package usuario;

public class Administrador extends Doador{

    public Administrador(String nome, String email, String identificador, String telefone, String senha, TipoDoador tipo){

        super(nome,email,identificador,telefone,senha,tipo);

    }

    @Override
    public String toString() {
        return "{Administrador: " +
            " nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", identificador='" + getIdentificador() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }
}
