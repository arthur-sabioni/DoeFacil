package item;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import email.Mailer;
import persistencia.PersistenciaItem;
import usuario.Doador;

public class ItemBag {

    private Mailer mailer;
    private int proximoId;
    private HashMap<Integer, Item> itens;

    public ItemBag(){

        this.mailer = new Mailer();
        itens = PersistenciaItem.carregarDadosItens();
        if(itens==null){
            proximoId = 0;
            itens = new HashMap<Integer, Item>();
        }
        else
            proximoId = itens.entrySet().stream().max(Comparator.comparing(Map.Entry::getKey)).get().getKey()+1;
    }

    public Item buscarItemPorId(int id){
        return itens.get(id);
    }

    public void adicionarItem(String nome, TipoItem tipo, String descricao, String localizacao, Doador doador){
        itens.put(proximoId, new Item(doador, proximoId, tipo, nome,  descricao, localizacao));
        proximoId++;
        PersistenciaItem.salvarDadosItens(itens);
    }

    public void cadastrarInteresse(int id, Doador interessado, String justificativa){
        this.itens.get(id).demonstrarInteresse(interessado, justificativa);
        PersistenciaItem.salvarDadosItens(itens);
    }

    public void confirmarDoacao(int idItem, int idInteresse){
        Item item = itens.get(idItem);
        Interesse interesse = item.getInteressados().stream().filter(i -> i.getId()==idInteresse).findFirst().get();
        item.setStatus(Status.doado);
        item.setDonatario(interesse.getInteressado());
        this.mailer.enviarEmail(item.getDoador().getEmail(), interesse.getInteressado().getEmail(), "O seu interesse para o item " + 
                                item.getNome() + " foi confirmado e você irá receber a doação!");
    }

    public List<Item> itensDoDoador(Doador doador){
        return itens.values().stream()
        .filter(item -> !item.getStatus().equals(Status.deletado))
        .filter(item -> item.getDoador().equals(doador))
        .collect(Collectors.toList());
    }

    public List<Item> itensDisponiveis(){
        return itens.values().stream()
        .filter(item -> item.getStatus().equals(Status.aprovado))
        .collect(Collectors.toList());
    }

    public List<Item> itensDisponiveisDoDoador(Doador doador){
        return itens.values().stream()
        .filter(item -> item.getStatus().equals(Status.aprovado))
        .filter(item -> item.getDoador().equals(doador))
        .collect(Collectors.toList());
    }

    public List<Item> buscarItem(String pesquisa){
        if(pesquisa.isEmpty() || pesquisa.isBlank())
            return itensDisponiveis();

        return itensDisponiveis().stream()
        .filter(item -> (item.getNome().toLowerCase().contains(pesquisa.toLowerCase()) || 
                        item.getDescricao().toLowerCase().contains(pesquisa.toLowerCase())))
        .collect(Collectors.toList());
    }

    public List<Item> buscaPendentes(){
        return itens.values().stream()
        .filter(item -> item.getStatus().equals(Status.pendente))
        .collect(Collectors.toList());
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


}
