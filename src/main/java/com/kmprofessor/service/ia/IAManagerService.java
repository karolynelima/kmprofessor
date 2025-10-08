package com.kmprofessor.service.ia;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class IAManagerService {

    private final Map<String, IAProviderService> providerServices;

    /**
     * Graças à injeção de dependência do Spring, este construtor receberá um Mapa
     * contendo todos os beans que implementam IAProviderService.
     * A chave do mapa será o nome do bean (ex: "deepseek").
     */
    public IAManagerService(Map<String, IAProviderService> providerServices) {
        this.providerServices = providerServices;
    }

    public Optional<IAProviderService> getProvider(String providerName) {
        // Retorna o serviço correspondente ao nome, se existir.
        // O nome viria do perfil do professor (ex: "deepseek", "chatgpt").
        return Optional.ofNullable(providerServices.get(providerName.toLowerCase()));
    }
}
