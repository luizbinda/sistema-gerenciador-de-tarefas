package com.basis.colatina.gerenciadordetarefas.util;


import com.basis.colatina.gerenciadordetarefas.GerenciadorDeTarefasApplication;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = GerenciadorDeTarefasApplication.class)
@WebAppConfiguration
@TestConfiguration
public class BaseIntTest {

    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    public void setWebApplicationContext(WebApplicationContext pWebApplicationContext) {
        webApplicationContext = pWebApplicationContext;
    }

    protected MockMvc getMockMvc() {
        return mockMvc;
    }

}
