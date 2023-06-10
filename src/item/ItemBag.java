package item;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ItemBag {

    private int proximoId;
    private HashMap<Integer, Item> itens;

    public ItemBag(){

        proximoId = 0;
        itens = new HashMap<Integer, Item>();

    }

    public void adicionarItem(Item item){
        this.itens.put(proximoId, item);
        this.proximoId++;
    }

    public List<Item> buscarItem(String pesquisa){
        return itens.values().stream()
        .filter(item -> item.getNome().toLowerCase().contains(pesquisa.toLowerCase()))
        .collect(Collectors.toList());
    }

    public List<Item> buscaPendentes(){
        return itens.values().stream()
        .filter(item -> item.getStatus().equals(Status.pendente))
        .collect(Collectors.toList());
    }

    public boolean atualizarItem(Item item){
        if (this.itens.containsKey(item.getId())){
            this.itens.put(item.getId(), item);
            return true;
        }
        return false;
    }

    public boolean deletarItem(Item item){
        return (this.itens.remove(item.getId()) != null);
    }

    public boolean aprovarItem(Item item){
        if (this.itens.containsKey(item.getId())){
            this.itens.get(item.getId()).setStatus(Status.aprovado);
            return true;
        }
        return false;        
    }

    public int getProximoId(){
        return this.proximoId;
    }
    
}
