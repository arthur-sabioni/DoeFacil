import interfaces.InterfaceCadastro;
import interfaces.InterfaceDoador;

public class Sistema {
    public static void main(String[] args){

        InterfaceCadastro ic = new InterfaceCadastro();

        while(true){
            while(ic.doadorLogado()==null)
                ic.mostrarOpcoes();
            InterfaceDoador id = new InterfaceDoador(ic.doadorLogado());
            id.mostrarOpcoes();
        }

    }

}