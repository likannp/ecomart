package br.com.alura.ecomart.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gerador")
public class GeradorDeProdutosController {
    private final ChatClient chatClient;

    public GeradorDeProdutosController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    @GetMapping
    public String gerarProdutos() {
        try {
            var pergunta = "Gere 5 produtos ecológicos";
            return this.chatClient.prompt()
                    .user(pergunta)
                    .call()
                    .content();
        } catch (Exception e) {
            return "Erro ao gerar produtos: " + e.getMessage();
        }
    }
}
