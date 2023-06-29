package usuario;

import java.io.Serializable;

public class Doador implements Serializable{

    private String nome;
    private String email;
    private String identificador;
    private String telefone;
    private String senha;
    private TipoDoador tipo;

    public Doador(String nome, String email, String identificador, String telefone, String senha, TipoDoador tipo) {
        this.nome = nome;
        this.email = email;
        this.identificador = identificador;
        this.telefone = telefone;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getIdentificador(){
        return this.identificador; // cpf ou cnpj, dependendo do TipoDoador.
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getSenha() {
        return this.senha;
    }

    public TipoDoador getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return "{Doador: " +
            " nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", identificador='" + getIdentificador() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }

}
