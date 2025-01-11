package com.vbuenor.envio_notificacao_cliente.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


public class NotificacaoDTO {
    @NotBlank
    private String nomeCliente;
    @NotBlank
    private String emailOrigem;
    @NotBlank
    private String emailDestinatario;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailOrigem() {
        return emailOrigem;
    }

    public void setEmailOrigem(String emailOrigem) {
        this.emailOrigem = emailOrigem;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

}
