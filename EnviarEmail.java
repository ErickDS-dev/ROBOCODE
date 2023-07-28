package aluno;

import javax.mail.*;
import javax.mail.internet.*;

public class EnviarEmail {
   public static void enviarEmailResultados() {
        // Informações do servidor de e-mail (Gmail neste caso)
        String host = "smtp.gmail.com";
        int porta = 587;
        String usuario = "xxx@gmail.com"; // Insira o seu e-mail do Gmail
        String senha = "1234578"; // Insira sua senha do Gmail

        // Destinatário e remetente
        String destinatario = "teste@gmail.com";
        String remetente = usuario; // O remetente é o mesmo e-mail do Gmail

        // Configuração das propriedades do servidor de e-mail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", porta);

        // Autenticação com o servidor de e-mail
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(usuario, senha);
                }
            });

        try {
            // Cria a mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject("Resultados da Batalha do Robocode");

            // Conteúdo da mensagem (aqui você pode inserir os resultados coletados)
            String corpoMensagem = "Número de vitórias: " + numVitorias + "\n" +
                                  "Número de derrotas: " + numDerrotas + "\n" +
                                  "Número de empates: " + numEmpates;
            message.setText(corpoMensagem);

            // Envia o e-mail
            Transport.send(message);

            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
