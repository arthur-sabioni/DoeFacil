import interfaces.InterfaceAdministrador;
import interfaces.InterfaceCadastro;
import interfaces.InterfaceDoador;
import usuario.Administrador;

public class Sistema {
    public static void main(String[] args){

        InterfaceCadastro ic = new InterfaceCadastro();

        while(true){
            while(ic.doadorLogado()==null)
                ic.mostrarOpcoes();
            InterfaceDoador i = null;
            if(ic.doadorLogado() instanceof Administrador)
                i = new InterfaceAdministrador((Administrador) ic.doadorLogado());
            else 
                i = new InterfaceDoador(ic.doadorLogado());
            i.mostrarOpcoes();
        }

    }

}