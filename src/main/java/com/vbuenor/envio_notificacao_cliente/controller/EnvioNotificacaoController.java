package com.vbuenor.envio_notificacao_cliente.controller;

import com.vbuenor.envio_notificacao_cliente.business.EnvioNotificacaoBusiness;
import com.vbuenor.envio_notificacao_cliente.dto.NotificacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.*;


@Tag(name = "Notificações", description = "API para envio de notificações (e-mail/WhatsApp) para clientes")
@RestController
@RequestMapping("/v1/notificacoes")
public class EnvioNotificacaoController {

    @Autowired
    private EnvioNotificacaoBusiness envioNotificacaoBusiness;

    @Operation(
            summary = "Envio de notificação",
            description = "Recebe os dados necessários (e-mail, telefone, texto) e realiza o envio simultâneo de e-mail e WhatsApp."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificação enviada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida (ex.: parâmetros faltando)."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a notificação.")
    })
    @PostMapping(path = "/enviar")
    public void envioNotificacao(@RequestBody NotificacaoDTO request) {
        envioNotificacaoBusiness.enviarNotificacao(request);
    }
}