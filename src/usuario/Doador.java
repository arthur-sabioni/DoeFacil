package usuario;

public class Doador {

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
        return null; // cpf ou cnpj, dependendo do TipoDoador. Vai ter lógica nisso?
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoDoador getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoDoador tipo) {
        this.tipo = tipo;
    }
    

}
