package interfaces;

import java.util.List;
import java.util.Scanner;

import item.Item;
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
                scanner = new Scanner(System.in);
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
        List<Item> itens = itemBag.buscaPendentes();
        if(itens.isEmpty()){
            System.out.println("Não há itens pendentes no sistema!");
            return;
        }
        System.out.println("Lista de itens pendentes:");
        for(Item item : itens)
            System.out.println(item.toStringDadosBasicosComDoador());   
    }

    public void aprovarItemPendente(){
        List<Item> itens = this.itemBag.buscaPendentes();
        if(itens.isEmpty()){
            return;
        }
        System.out.println("Selecione um item para aprovar dentre a lista abaixo:");
        listarItensPendentes();
        int idItemSelecionado = selecionarItemEmLista(itens);
        this.itemBag.aprovarItem(idItemSelecionado, user);
    }

    public void reprovarItemPendente(){
        List<Item> itens = this.itemBag.buscaPendentes();
        if(itens.isEmpty()){
            return;
        }
        System.out.println("Selecione um item para reprovar dentre a lista abaixo:");
        listarItensPendentes();
        int idItemSelecionado = selecionarItemEmLista(itens);
        System.out.println("Informe a justificativa da rejeição: ");
        scanner = new Scanner(System.in);
        String justificativa = scanner.nextLine();
        this.itemBag.rejeitarItem(idItemSelecionado, user, justificativa);
    }
}
