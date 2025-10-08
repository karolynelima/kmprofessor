package com.kmprofessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmprofessor.service.ia.IAManagerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IAManagerService iaManagerService;

    @Operation(
        summary = "Testa o provedor DeepSeek/OpenAI",
        description = "Executa um prompt em um provedor de IA e retorna o texto"
    )
    @ApiResponse(responseCode = "200", description = "Resposta do provedor")
    @ApiResponse(responseCode = "400", description = "Provedor não encontrado")
    @GetMapping("/deepseek")
    public ResponseEntity<String> testDeepSeek(
            @Parameter(description = "Texto de entrada") @RequestParam String prompt,
            @Parameter(description = "API Key do provedor") @RequestParam String apiKey,
            @Parameter(description = "Nome do provedor (default=deepseek)")
            @RequestParam(defaultValue = "deepseek") String provider
    ) {
        return iaManagerService.getProvider(provider)
                .map(providerService -> ResponseEntity.ok(providerService.gerarResposta(prompt, apiKey)))
                .orElseGet(() -> ResponseEntity.badRequest().body("Provedor de IA não encontrado: " + provider));
    }
}
