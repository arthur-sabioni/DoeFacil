package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArquivoUtil {

    private static String BASE_PATH = "dados/";
    
    public static ObjectOutputStream abrirArquivoParaEscrita(String nomeArquivo){
        try {
            return new ObjectOutputStream(new FileOutputStream(BASE_PATH + nomeArquivo));
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo " + nomeArquivo);
            e.printStackTrace();
        }
        return null;
    }

    public static ObjectInputStream abrirArquivoParaLeitura(String nomeArquivo){
        try {
            return new ObjectInputStream(new FileInputStream(BASE_PATH + nomeArquivo));
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo " + nomeArquivo);
            e.printStackTrace();
        }
        return null;
    }
}
