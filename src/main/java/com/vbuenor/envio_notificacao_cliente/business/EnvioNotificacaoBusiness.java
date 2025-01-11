package com.vbuenor.envio_notificacao_cliente.business;

import com.vbuenor.envio_notificacao_cliente.dto.NotificacaoDTO;
import jakarta.mail.*;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import static com.vbuenor.envio_notificacao_cliente.business.MontaCorpoEmailBusiness.montarTextoEmail;

@Service
public class EnvioNotificacaoBusiness {

    @Autowired
    private JavaMailSender mailSender;

    public static final String ASSUNTO = "Teste";
    public static final String UTF_8 = "UTF-8";

    public void enviarNotificacao(NotificacaoDTO request) {

        enviarEmail(
                request.getEmailOrigem(),
                request.getEmailDestinatario(),
                ASSUNTO,
                montarTextoEmail(request.getNomeCliente())
        );
    }

    public void enviarEmail(String from, String to, String assunto, String texto) {
        try {

            MimeMessage mensagem = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensagem, UTF_8);

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(assunto);
            helper.setText(texto, false);

            mailSender.send(mensagem);
            System.out.println("[OK] E-mail enviado com sucesso!");
        } catch (MessagingException e) {
            System.out.println("[ERRO] Falha ao enviar e-mail: " + e.getMessage());
        }
    }

}
