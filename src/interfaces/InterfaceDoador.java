package interfaces;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import item.Interesse;
import item.Item;
import item.ItemBag;
import item.TipoItem;
import usuario.Doador;

public class InterfaceDoador implements Interface {

    private static String[] opcoes = {
        "1 - Pesquisar itens disponíveis para doação",
        "2 - Demonstrar interesse em item disponível para doação",
        "3 - Cadastrar novo item para doação",
        "4 - Visualizar interessados em doação dos seus itens",
        "5 - Aprovar doação de algum dos seus itens",
        "6 - Deletar item cadastrado",
        "7 - Sair"
    };

    protected ItemBag itemBag;
    protected Doador user;
    protected Scanner scanner;

    public InterfaceDoador(Doador user) {

        this.scanner = new Scanner(System.in);
        this.itemBag = new ItemBag();
        this.user = user;

    }

    public void mostrarOpcoes(){
        while(true){
            Interface.printMenu(opcoes);
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1: buscarItens(); break;
                    case 2: demonstrarInteresse(); break;
                    case 3: cadastrarNovoItem(); break;
                    case 4: visualizarInteressados(); break;
                    case 5: aprovarDoacao(); break;
                    case 6: deletarItem(); break;
                    case 7: System.exit(0);
                    default: System.out.println("Por favor digite um inteiro entre 1 e " + opcoes.length);
                }
            }
            catch (NumberFormatException e){
                System.out.println("Por favor digite um inteiro entre 1 e " + opcoes.length);
            }
        }
    }

    public void exibirItens(List<Item> itens){
        for(Item item : itens)
            System.out.println(item.toStringDadosBasicos());
    }

    public int selecionarItemEmLista(List<Item> itens){
        List<Integer> itemIds = itens.stream().map(Item::getId).collect(Collectors.toList());
        while(true){
            try{
                System.out.print("\nDigite o id do item que você quer selecionar: ");
                int id = Integer.parseInt(scanner.nextLine());
                if(itemIds.contains(id)){
                    scanner.close();
                    return id;
                }
                System.out.println("Por favor digite um id válido de um dos itens da lista!");
            }
            catch (NumberFormatException e){       
                System.out.println("Por favor digite um número inteiro!");
            }
        }      
    }

    public void buscarItens(){
        System.out.print("Digite o texto da pesquisa (deixe em branco para buscar todos os itens): ");
        String pesquisa = scanner.nextLine();
        List<Item> resultado = itemBag.buscarItem(pesquisa);
        if(resultado.isEmpty()){
            System.out.println("Nenhum item foi encontrado com a sua pesquisa!");
            return;
        }
        System.out.println("Resultados da pesquisa:");
        exibirItens(resultado);     
    }    

    public void demonstrarInteresse(){
        List<Item> itensDisponiveis = itemBag.itensDisponiveis();
        if(itensDisponiveis.isEmpty()){
            System.out.println("Não há itens disponíveis para doação!");
            return;
        }
        System.out.println("Selecione um item disponível para doação dentre a lista abaixo:");
        exibirItens(itensDisponiveis);
        int idItemSelecionado = selecionarItemEmLista(itensDisponiveis);
        System.out.print("Digite a justificativa do seu interesse: ");
        String justificativa = scanner.nextLine();
        this.itemBag.cadastrarInteresse(idItemSelecionado, user, justificativa);
        System.out.println(String.format("O seu interesse no item de id={} foi registrado com sucesso!", idItemSelecionado));
    }    

    public void cadastrarNovoItem(){
        TipoItem tipoItem = null;
        while (tipoItem == null){
            System.out.print("1 - Mobilha\n"
                            + "2 - Vestuário\n"
                            + "3 - Material de Construção\n"
                            + "4 - Roupa de Cama\n"
                            + "5 - Utensílios Domésticos\n"
                            + "6 - Eletrônico\n");
            try {
                System.out.println("Digite o tipo do item: ");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1: tipoItem = TipoItem.mobilha; break;
                    case 2: tipoItem = TipoItem.vestuario; break;
                    case 3: tipoItem = TipoItem.materialDeConstrucao; break;
                    case 4: tipoItem = TipoItem.roupaDeCama; break;
                    case 5: tipoItem = TipoItem.utensiliosDomesticos; break;
                    case 6: tipoItem = TipoItem.eletronico; break;
                    default: System.out.println("Por favor digite um número entre 1 e 6!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Por favor digite um número entre 1 e 6!");
            }
        }
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a localização: ");
        String localizacao = scanner.nextLine();
        this.itemBag.adicionarItem(nome, tipoItem, descricao, localizacao, this.user);
        System.out.println(String.format("Novo item {} cadastrado com sucesso!", nome));
    }

    public void visualizarInteressados(){
        List<Item> itens = this.itemBag.itensDisponiveisDoDoador(user);
        if(itens.isEmpty()){
            System.out.println("Você não possui nenhum item disponível!");
            return;
        }
        System.out.println("Relação de interesses para todos os seus itens disponíveis:");
        for(Item item : itens)
            System.out.println(item.exibirInteresses());
    }

    public void aprovarDoacao(){
        List<Item> itens = this.itemBag.itensDisponiveisDoDoador(user);
        
        if(itens.isEmpty())
            return;

        System.out.println("Selecione um item para aprovar a doação dentre a lista abaixo:");
        visualizarInteressados();
        int idItemSelecionado = selecionarItemEmLista(itens);
        Item itemASerDoado = itemBag.buscarItemPorId(idItemSelecionado);
        List<Integer> idsInteresses = itemASerDoado.getInteressados().stream().map(Interesse::getId).collect(Collectors.toList());

        if(idsInteresses.isEmpty()){
            System.out.println("O item selecionado não possui nenhum interessado para receber a doação!");
            return;
        }

        while(true){
            try{
                System.out.print("\nDigite o id do interesse para o qual o item será doado: ");
                int idInteresse = Integer.parseInt(scanner.nextLine());
                if(idsInteresses.contains(idInteresse)){
                    itemBag.confirmarDoacao(idItemSelecionado, idInteresse);
                    System.out.println(String.format("Item de id={} será doado para o interessado com id de interesse={}!", 
                                                    idItemSelecionado, idInteresse));
                    return;
                }
                System.out.println("Por favor digite um id válido de um dos interesses para o item selecionado!");
            }
            catch (NumberFormatException e){       
                System.out.println("Por favor digite um número inteiro!");
            }
        }
    }

    public void deletarItem(){
        List<Item> itens = this.itemBag.itensDoDoador(user);
        if(itens.isEmpty()){
            System.out.println("Você não tem itens cadastrados!");
            return;
        }
        System.out.println("Selecione um item para deleter dentre a lista abaixo:");
        exibirItens(itens);
        int idItemSelecionado = selecionarItemEmLista(itens);
        this.itemBag.deletarItem(idItemSelecionado);
        System.out.println(String.format("Item de id={} deletado com sucesso!", idItemSelecionado));
    }
}
