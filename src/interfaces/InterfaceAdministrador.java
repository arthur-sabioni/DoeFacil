package interfaces;

import java.util.Scanner;

import usuario.Administrador;

public class InterfaceAdministrador extends InterfaceDoador {

    private static String[] opcoes = {
        "--OPÇÕES DE DOADOR--\n1 - Pesquisar itens disponíveis para doação",
        "2 - Demonstrar interesse em item disponível para doação",
        "3 - Cadastrar novo item para doação",
        "4 - Visualizar interessados em doação dos seus itens",
        "5 - Aprovar doação de algum dos seus itens",
        "6 - Deletar item cadastrado",
        "--OPÇÕES DE ADMINISTRADOR--\n7 - Listar itens com status pendente",
        "8 - Aprovar item com status pendente",
        "9 - Reprovar item com status pendente",
        "0 - Sair"
    };


    public InterfaceAdministrador(Administrador user){
        super(user);
        this.user = user;
    }

    public void mostrarOpcoes(){
        while(true){
            Interface.printMenu(opcoes);
            try {
                scanner.reset();
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 1: buscarItens(); break;
                    case 2: demonstrarInteresse(); break;
                    case 3: cadastrarNovoItem(); break;
                    case 4: visualizarInteressados(); break;
                    case 5: aprovarDoacao(); break;
                    case 6: deletarItem(); break;
                    case 7: listarItensPendentes(); break;
                    case 8: aprovarItemPendente(); break;
                    case 9: reprovarItemPendente(); break;
                    case 0: System.exit(0); break;
                    default: System.out.println("Por favor digite um inteiro entre 0 e 9!");
                }
            }
            catch (Exception ex){
                System.out.println("Por favor digite um inteiro entre 0 e 9!");
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
