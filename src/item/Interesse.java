package item;

import usuario.Doador;

public class Interesse {
    
    private int id;
    private Doador interessado;
    private String justificativa;
    private boolean confirmado;

    public Interesse(int id, Doador interessado, String justificativa) {
        this.id = id;
        this.interessado = interessado;
        this.justificativa = justificativa;
        this.confirmado = false;
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

    public boolean estaConfirmado(){
        return confirmado;
    }

    public void confirmarInteresse(){
        confirmado = true;
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
