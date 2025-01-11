package com.vbuenor.envio_notificacao_cliente.business;



public class MontaCorpoEmailBusiness {

    public static String montarTextoEmail(String nomeCliente, String nomeEmpresa) {
        return "Olá, " + nomeCliente + ",\n\n"
                + "Tudo bem?\n\n"
                + "Sou Caio, Consultor Comercial da Humani Corretora, uma empresa especializada em Gestão de Planos de Saúde.\n\n"
                + "Tentei contato com você nesta semana para falarmos do reajuste do seu plano de saúde, que está sendo praticado na casa dos 20%.\n\n"
                + "Gostaria de apresentar um estudo comparativo personalizado para a " + nomeEmpresa + ","
                + "com opções de migração para planos equivalentes ou até superiores, que podem oferecer economia e benefícios adicionais.\n\n"
                + "Que tal agendarmos uma reunião, seja por videochamada ou presencial? Assim, posso detalhar as opções e esclarecer quaisquer dúvidas. "
                + "Fique à vontade para sugerir o melhor horário ou entrar em contato pelo telefone/WhatsApp (11) 98080-7721.\n\n"
                + "Aguardo seu retorno!\n\n"
                + "Obrigado e até breve,\n"
                + "Caio\n"
                + "Consultor Comercial\n"
                + "Humani Corretora";
    }
}
