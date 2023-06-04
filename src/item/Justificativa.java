package item;

public class Justificativa {

    private Item item;
    private String mensagem;

    public Justificativa(Item item, String mensagem) {
        this.item = item;
        this.mensagem = mensagem;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    
}
