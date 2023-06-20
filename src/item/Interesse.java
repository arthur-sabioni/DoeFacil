package item;

import usuario.Doador;

public class Interesse {
    
    private int id;
    private Doador interessado;
    private String justificativa;

    public Interesse(int id, Doador interessado, String justificativa) {
        this.id = id;
        this.interessado = interessado;
        this.justificativa = justificativa;
    }

    public int getId(){
        return this.id;
    }

    public Doador getInteressado() {
        return this.interessado;
    }

    public void setInteressado(Doador interessado) {
        this.interessado = interessado;
    }

    public String getJustificativa() {
        return this.justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    @Override
    public String toString() {
        return "{" +
            " idInteresse='" + getId() + "'" + 
            " interessado='" + getInteressado().getNome() + "'" +
            ", justificativa='" + getJustificativa() + "'" +
            "}";
    }
}
