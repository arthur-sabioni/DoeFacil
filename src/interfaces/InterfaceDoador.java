package interfaces;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import email.Mailer;
import item.Item;
import item.ItemBag;
import item.TipoItem;
import usuario.Doador;

public class InterfaceDoador implements Interface {

    private static String[] opcoes = {
        "1 - Pesquisar itens disponíveis para doação",
        "2 - Cadastrar novo item para doação",
        "3 - Deletar item cadastrado",
        "4 - Demonstrar interesse em itens disponíveis para doação",
        "5 - Aprovar doação de algum dos seus itens",
        "6 - Sair"
    };

    protected ItemBag itemBag;
    protected Mailer mailer;
    protected Doador user;
    private Scanner scanner;

    public InterfaceDoador(Doador user) {

        this.scanner = new Scanner(System.in);
        this.itemBag = new ItemBag();
        this.mailer = new Mailer();
        this.user = user;

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
                    case 4: demonstrarInteresse(null);
                    case 5: aprovarInteresses();
                    case 6: System.exit(0);
                    default: System.out.println("Por favor digite um inteiro entre 1 e " + opcoes.length);
                }
            }
            catch (Exception ex){
                System.out.println("Por favor digite um inteiro entre 1 e " + opcoes.length);
                scanner.next();
            }
        }
    }

    public void cadastrarNovoItem(){
        TipoItem tipoItem = null;
        while (tipoItem == null){
            System.out.print("1 - Mobilha\n"
                            + "2 - Vestuário\n"
                            + "3 - Material de Construção\n"
                            + "4 - Roupa de Cama\n"
                            + "5 - Utensílios Domésticos\n"
                            + "6 - Eletrônico\n"
                            + "Qual o tipo do item? ");
            try {
                int opcao = scanner.nextInt();
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
            catch (Exception ex){
                System.out.println("Por favor digite um número entre 1 e 6!");
                scanner.next();
            }
        }
        scanner.nextLine();
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a localização: ");
        String localizacao = scanner.nextLine();
        this.itemBag.adicionarItem(nome, tipoItem, descricao, localizacao, this.user);
    }

    public void deletarItem(){
        List<Item> itens = this.itemBag.itensPorDoador(user);
        if(itens.isEmpty()){
            System.out.println("Você não tem itens cadastrados!");
            return;
        }
        List<Integer> itemIds = itens.stream().map(Item::getId).collect(Collectors.toList());
        System.out.println("Você tem os seguintes itens cadastrados:");
        for(Item item : itens)
            System.out.println(item.toStringSemDoador());
        System.out.print("\nDigite o id do item que você quer deletar: ");
        while(true){
            try{
                int idToDelete = scanner.nextInt();
                if(itemIds.contains(idToDelete)){
                    this.itemBag.deletarItem(idToDelete);
                    return;
                }
                System.out.println("Por favor digite um id válido de um dos seus itens!");
                scanner.next();
            }
            catch (Exception ex){       
                System.out.println("Por favor digite um número inteiro!");
                scanner.next();
            }
        }
    }

    public void aprovarInteresses(){
        
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
        for(Item item : resultado)
            System.out.println(item.toStringSemDoador());        
    }

    public void demonstrarInteresse(Item item){
        
    }
    
}
