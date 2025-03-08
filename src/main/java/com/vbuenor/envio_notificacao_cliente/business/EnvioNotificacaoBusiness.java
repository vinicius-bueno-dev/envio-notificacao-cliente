package com.vbuenor.envio_notificacao_cliente.business;

import com.vbuenor.envio_notificacao_cliente.dto.NotificacaoDTO;
import jakarta.mail.*;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import static com.vbuenor.envio_notificacao_cliente.business.MontaCorpoEmailBusiness.montarTextoEmail;

@Service
@Log4j2
@RequiredArgsConstructor
public class EnvioNotificacaoBusiness {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailOrigem;

    public static final String ASSUNTO = "Solução para o Reajuste do Plano de Saúde da Sua Empresa";
    public static final String UTF_8 = "UTF-8";


    public void enviarNotificacao(NotificacaoDTO request) {

        enviarEmail(
                emailOrigem,
                request.getEmailDestinatario(),
                ASSUNTO,
                montarTextoEmail(request.getNomeCliente(), request.getNomeEmpresa())
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

            log.info("[OK] E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            log.error("[ERRO] Falha ao enviar e-mail: " + e.getMessage());
        }
    }

}
