package com.basis.colatina.gerenciadordetarefas.resource;

import com.basis.colatina.gerenciadordetarefas.GerenciadorDeTarefasApplication;
import com.basis.colatina.gerenciadordetarefas.builder.ResponsavelBuilder;
import com.basis.colatina.gerenciadordetarefas.domain.Responsavel;
import com.basis.colatina.gerenciadordetarefas.service.mapper.ResponsavelMapper;
import com.basis.colatina.gerenciadordetarefas.util.BaseIntTest;
import com.basis.colatina.gerenciadordetarefas.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = GerenciadorDeTarefasApplication.class)
public class ResponsavelIT extends BaseIntTest {

  @Autowired
  private ResponsavelBuilder builder;

  @Autowired
  private ResponsavelMapper responsavelMapper;

  private final String URL = "/api/responsavel";

  @Test
  public void storeResponsavel() throws Exception {
    Responsavel responsavel = builder.buildEntity();
    getMockMvc().perform(post(URL)
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(responsavelMapper.toDTO(responsavel))))
            .andExpect(status().isCreated());
  }

}
