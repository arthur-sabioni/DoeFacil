package item;

import usuario.Doador;

public class Interesse {
    
    private Doador interessado;
    private String justificativa;

    public Interesse(Doador interessado, String justificativa) {
        this.interessado = interessado;
        this.justificativa = justificativa;
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


}
