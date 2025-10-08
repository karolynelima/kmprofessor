package com.kmprofessor.service.ia;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

/**
 * Implementação do provedor de IA para OpenAI usando o Spring AI.
 */
@Service("openai")
public class OpenAiProviderService implements IAProviderService {

    private final ChatClient chatClient;

    public OpenAiProviderService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
        // Ajuste o model/temperature conforme seu application.yml
    }

    @Override
    public String gerarResposta(String prompt, String apiKeyIgnorado) {
        // A API key é lida da configuração; por padrão não é definida por requisição.
        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content(); // já retorna String
    }
}
