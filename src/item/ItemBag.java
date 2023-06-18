package item;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import usuario.Doador;
import util.ArquivoUtil;

public class ItemBag {

    private static String ARQUIVO_DADOS = "dadosItens.dat";
    private int proximoId;
    private HashMap<Integer, Item> itens;

    public ItemBag(){

        itens = carregarDadosItens();
        if(itens==null){
            proximoId = 0;
            itens = new HashMap<Integer, Item>();
        }
        else
            proximoId = itens.entrySet().stream().max(Comparator.comparing(Map.Entry::getKey)).get().getKey()+1;
        System.out.println("Classe Item Bag inicializada com proximoId:" + proximoId + " e itens:");
        System.out.println(itens);
    }

    public void adicionarItem(String nome, TipoItem tipo, String descricao, String localizacao, Doador doador){
        this.itens.put(proximoId, new Item(doador, proximoId, tipo, nome,  descricao, localizacao));
        this.proximoId++;
        this.salvarDadosItens();
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
        if (this.itens.containsKey(item.getId())){
            this.itens.put(item.getId(), item);
            return true;
        }
        return false;
    }

    public void deletarItem(int id){
        this.itens.get(id).setStatus(Status.deletado);
        this.salvarDadosItens();
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
    
    public void salvarDadosItens(){
        ObjectOutputStream oos = ArquivoUtil.abrirArquivoParaEscrita(ARQUIVO_DADOS);
        try {
            oos.writeObject(this.itens);
            oos.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados de itens.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap<Integer, Item> carregarDadosItens(){
        HashMap<Integer, Item> itens = null;
        try {
            ObjectInputStream ois = ArquivoUtil.abrirArquivoParaLeitura(ARQUIVO_DADOS);
            itens = (HashMap<Integer, Item>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erro ao carregar os dados de cadastro, será inicializado um novo conjunto de itens vazio.");
        }
        return itens;
    }

}
