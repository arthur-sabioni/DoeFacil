package interfaces;

import java.util.Scanner;

import cadastro.SistemaCadastro;
import usuario.Doador;
import usuario.TipoDoador;

public class InterfaceCadastro implements Interface{

    private SistemaCadastro sistema;
    private Scanner scanner;

    public InterfaceCadastro(){

        this.sistema = new SistemaCadastro();
        this.scanner = new Scanner(System.in);

    }

    private static String[] opcoes = {"1- Realizar login ",
            "2- Realizar cadastro",
            "3- Sair",
    };

    public void mostrarOpcoes(){
        while (sistema.doadorLogado()==null){
            Interface.printMenu(opcoes);
            try {
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 1: realizarLogin(); break;
                    case 2: realizarCadastro(); break;
                    case 3: System.exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Por favor digite um inteiro entre 1 e " + opcoes.length);
                scanner.next();
            }
        }
    }

    public void realizarLogin(){
        scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        sistema.login(email, senha);
    }

    public void realizarCadastro(){
        Boolean administrador = null;
        TipoDoador tipoDoador = null;

        while (administrador == null){
            System.out.print("O doador a ser cadastrado é administrador? (1) Sim ou (2) Não? ");
            try {
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 1: administrador = true; break;
                    case 2: administrador = false; break;
                    default: System.out.println("Por favor digite 1 ou 2!");
                }
            }
            catch (Exception ex){
                System.out.println("Por favor digite 1 ou 2!");
                scanner.next();
            }
        }

        while (tipoDoador == null){
            System.out.print("Qual o tipo do doador? (1) Pessoa Física ou (2) Pessoa Jurídica? ");
            try {
                int opcao = scanner.nextInt();
                switch (opcao){
                    case 1: tipoDoador = TipoDoador.PessoaFisica; break;
                    case 2: tipoDoador = TipoDoador.PessoaJuridica; break;
                    default: System.out.println("Por favor digite 1 ou 2!");
                }
            }
            catch (Exception ex){
                System.out.println("Por favor digite 1 ou 2!");
                scanner.next();
            }
        }
        scanner.nextLine();
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        if(tipoDoador == TipoDoador.PessoaFisica)
            System.out.print("Digite o CPF: ");
        else if(tipoDoador == TipoDoador.PessoaJuridica)
            System.out.print("Digite o CNPJ: ");
        String identificador = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine(); 
        this.sistema.cadastrarDoador(nome, email, identificador, telefone, senha, tipoDoador, administrador);
    }

    public Doador doadorLogado(){
        return this.sistema.doadorLogado();
    }
    
}
