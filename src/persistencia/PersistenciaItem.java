package persistencia;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import item.Item;
import util.ArquivoUtil;

public class PersistenciaItem {
    
    private static String ARQUIVO_DADOS = "dadosItens.dat";
    
    public static void salvarDadosItens(HashMap<Integer, Item> itens){
        ObjectOutputStream oos = ArquivoUtil.abrirArquivoParaEscrita(ARQUIVO_DADOS);
        try {
            oos.writeObject(itens);
            oos.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados de itens.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static HashMap<Integer, Item> carregarDadosItens(){
        HashMap<Integer, Item> itens = null;
        try {
            ObjectInputStream ois = ArquivoUtil.abrirArquivoParaLeitura(ARQUIVO_DADOS);
            itens = (HashMap<Integer, Item>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erro ao carregar os dados de itens.");
        }
        return itens;
    }

}
