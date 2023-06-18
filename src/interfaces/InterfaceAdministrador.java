package interfaces;

import java.util.Scanner;

import item.Item;
import usuario.Administrador;

public class InterfaceAdministrador extends InterfaceDoador {

    private static String[] opcoes = {
        "--OPÇÕES DE DOADOR--\n1 - Pesquisar itens disponíveis para doação",
        "2 - Cadastrar novo item para doação",
        "3 - Deletar item cadastrado",
        "4 - Demonstrar interesse em itens disponíveis para doação",
        "5 - Aprovar doação de algum dos seus itens",
        "--OPÇÕES DE ADMINISTRADOR--\n6 - Listar itens com status pendente",
        "7 - Aprovar item com status pendente",
        "8 - Reprovar item com status pendente",
        "9 - Sair"
    };

    //private Administrador user;
    private Scanner scanner;

    public InterfaceAdministrador(Administrador user){
        super(user);
        this.user = user;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarOpcoes(){
        while(true){
            Interface.printMenu(opcoes);
            try {
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 1: buscarItens(); break;
                    case 2: cadastrarNovoItem(); break;
                    case 3: deletarItem(); break;
                    case 4: demonstrarInteresse(null); break;
                    case 5: aprovarInteresses(); break;
                    case 6: listarItensPendentes(); break;
                    case 7: aprovarItemPendente(null); break;
                    case 8: reprovarItemPendente(); break;
                    case 9: System.exit(0); break;
                    default: System.out.println("Por favor digite um inteiro entre 1 e " + opcoes.length);
                }
            }
            catch (Exception ex){
                System.out.println("Por favor digite um inteiro entre 1 e " + opcoes.length);
                scanner.next();
            }        
        }
    }

    public void listarItensPendentes(){

    }

    public void reprovarItemPendente(){

    }

    public void aprovarItemPendente(Item item){
    }

}
