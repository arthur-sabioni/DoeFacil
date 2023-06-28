package email;

public class Mailer {
    
    public Mailer(){

    }

    public void enviarEmail(String remetente, String destinatario, String conteudo){
        System.out.println("Email enviado do remetente {" + remetente + "} para o destinatário {" + destinatario + "} " +
        "com o conteúdo: \n{\n" + conteudo + "\n}\n");
    }
}
