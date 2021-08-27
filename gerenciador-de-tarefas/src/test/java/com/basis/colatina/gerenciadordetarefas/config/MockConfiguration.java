package com.basis.colatina.gerenciadordetarefas.config;


import com.basis.colatina.gerenciadordetarefas.service.feing.AnexoClient;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MockConfiguration {

    @MockBean
    private AnexoClient anexoClient;

    @PostConstruct
    public void mock() {
//        Mockito.when(anexoClient.uploadAnexo()).thenReturn(null);
    }

}
