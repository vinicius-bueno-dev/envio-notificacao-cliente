package com.vbuenor.envio_notificacao_cliente.business;

import org.springframework.stereotype.Service;

@Service
public class MontaCorpoEmailBusiness {
    public static final String TEXTO_CORPO_EMAIL = "teste do Maio pro cliente ";

    public static String montarTextoEmail(String nomeCliente) {
        return TEXTO_CORPO_EMAIL + nomeCliente;
    }
}
