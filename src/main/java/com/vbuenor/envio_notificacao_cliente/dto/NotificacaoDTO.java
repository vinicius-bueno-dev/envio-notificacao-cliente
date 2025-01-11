package com.vbuenor.envio_notificacao_cliente.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NotificacaoDTO {
    @NotBlank
    private String nomeCliente;
    @NotBlank
    private String nomeEmpresa;
    @NotBlank
    private String emailDestinatario;
}
