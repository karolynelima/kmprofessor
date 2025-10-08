package com.kmprofessor.service.ia;

/**
 * Interface que define o contrato para qualquer provedor de IA.
 * Cada implementação (DeepSeek, ChatGPT, etc.) deve seguir este contrato.
 */
public interface IAProviderService {

    /**
     * Gera uma resposta usando o provedor de IA.
     * @param prompt A pergunta ou comando para a IA.
     * @param apiKey A chave de API específica para esta requisição (pode ser nula se uma chave global for usada).
     * @return A resposta gerada pela IA.
     */
    String gerarResposta(String prompt, String apiKey);

}
