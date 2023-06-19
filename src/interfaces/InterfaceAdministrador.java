package interfaces;

import java.util.Scanner;

import usuario.Administrador;

public class InterfaceAdministrador extends InterfaceDoador {

    private static String[] opcoes = {
        "--OPÇÕES DE DOADOR--\n1 - Pesquisar itens disponíveis para doação",
        "2 - Demonstrar interesse em item disponível para doação",
        "3 - Cadastrar novo item para doação",
        "4 - Aprovar doação de algum dos seus itens",
        "5 - Deletar item cadastrado",
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
                    case 2: demonstrarInteresse(); break;
                    case 3: cadastrarNovoItem(); break;
                    case 4: aprovarDoacao(); break;
                    case 5: deletarItem(); break;
                    case 6: listarItensPendentes(); break;
                    case 7: aprovarItemPendente(); break;
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

    public void aprovarItemPendente(){
    }

}
