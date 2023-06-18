package persistencia;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import usuario.Doador;
import util.ArquivoUtil;

public class PersistenciaCadastro {

    private static String ARQUIVO_DADOS = "dadosCadastro.dat";

    public static void salvarDadosCadastro(ArrayList<Doador> doadores){
        ObjectOutputStream oos = ArquivoUtil.abrirArquivoParaEscrita(ARQUIVO_DADOS);
        try {
            oos.writeObject(doadores);
            oos.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados de cadastro.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Doador> carregarDadosCadastro(){
        ArrayList<Doador> doadores = null;
        try {
            ObjectInputStream ois = ArquivoUtil.abrirArquivoParaLeitura(ARQUIVO_DADOS);
            doadores = (ArrayList<Doador>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erro ao carregar os dados de cadastro.");
        }
        return doadores;
    }

}
