package item;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import persistencia.PersistenciaItem;
import usuario.Doador;

public class ItemBag {

    private int proximoId;
    private HashMap<Integer, Item> itens;

    public ItemBag(){

        itens = PersistenciaItem.carregarDadosItens();
        if(itens==null){
            proximoId = 0;
            itens = new HashMap<Integer, Item>();
        }
        else
            proximoId = itens.entrySet().stream().max(Comparator.comparing(Map.Entry::getKey)).get().getKey()+1;
    }

    public void adicionarItem(String nome, TipoItem tipo, String descricao, String localizacao, Doador doador){
        itens.put(proximoId, new Item(doador, proximoId, tipo, nome,  descricao, localizacao));
        proximoId++;
        PersistenciaItem.salvarDadosItens(itens);
    }

    public List<Item> itensPorDoador(Doador doador){
        return itens.values().stream()
        .filter(item -> !item.getStatus().equals(Status.deletado))
        .filter(item -> item.getDoador().equals(doador))
        .collect(Collectors.toList());
    }

    public List<Item> buscarItem(String pesquisa){
        if(pesquisa.isEmpty() || pesquisa.isBlank())
            return itens.values().stream()
            .filter(item -> item.getStatus().equals(Status.aprovado))
            .collect(Collectors.toList());

        return itens.values().stream()
        .filter(item -> item.getStatus().equals(Status.aprovado))
        .filter(item -> (item.getNome().toLowerCase().contains(pesquisa.toLowerCase()) || 
                        item.getDescricao().toLowerCase().contains(pesquisa.toLowerCase())))
        .collect(Collectors.toList());
    }

    public List<Item> buscaPendentes(){
        return itens.values().stream()
        .filter(item -> item.getStatus().equals(Status.pendente))
        .collect(Collectors.toList());
    }

    public boolean atualizarItem(Item item){
        if (itens.containsKey(item.getId())){
            itens.put(item.getId(), item);
            return true;
        }
        return false;
    }

    public void deletarItem(int id){
        itens.get(id).setStatus(Status.deletado);
        PersistenciaItem.salvarDadosItens(itens);
    }

    public boolean aprovarItem(Item item){
        if (itens.containsKey(item.getId())){
            itens.get(item.getId()).setStatus(Status.aprovado);
            return true;
        }
        return false;        
    }

    public int getProximoId(){
        return proximoId;
    }

}
