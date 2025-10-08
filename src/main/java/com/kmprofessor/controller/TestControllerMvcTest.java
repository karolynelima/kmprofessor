// package com.kmprofessor.controller;

// import com.kmprofessor.service.ia.IAProviderService;
// import com.kmprofessor.service.ia.IAManagerService;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;

// import java.util.Optional;

// import static org.mockito.ArgumentMatchers.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest(TestController.class)
// class TestControllerMvcTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private IAManagerService iaManagerService;

//     @MockBean
//     private IAProviderService providerService; // mock do provider real

//     @Test
//     void deveRetornar200_quandoProviderExiste() throws Exception {
//         Mockito.when(iaManagerService.getProvider(eq("deepseek")))
//                .thenReturn(Optional.of(providerService));
//         Mockito.when(providerService.gerarResposta(anyString(), anyString()))
//                .thenReturn("ok-deepseek");

//         mockMvc.perform(get("/test/deepseek")
//                 .param("prompt", "Olá")
//                 .param("apiKey", "XYZ")
//                 .param("provider", "deepseek"))
//                 .andExpect(status().isOk())
//                 .andExpect(content().string("ok-deepseek"));
//     }

//     @Test
//     void deveRetornar400_quandoProviderNaoExiste() throws Exception {
//         Mockito.when(iaManagerService.getProvider(eq("xpto")))
//                .thenReturn(Optional.empty());

//         mockMvc.perform(get("/test/deepseek")
//                 .param("prompt", "Olá")
//                 .param("apiKey", "XYZ")
//                 .param("provider", "xpto"))
//                 .andExpect(status().isBadRequest())
//                 .andExpect(content().string("Provedor de IA não encontrado: xpto"));
//     }
// }
