package interfaces;

public interface Interface {

    public static void printMenu(String[] opcoes){
        System.out.println();
        for (String opcao : opcoes){
            System.out.println(opcao);
        }
        System.out.print("Escolha uma opcao: ");
    }

    public void mostrarOpcoes();
    
}
