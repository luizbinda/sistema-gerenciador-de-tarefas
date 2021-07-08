package com.basis.colatina.gerenciadordetarefas.resource;

import com.basis.colatina.gerenciadordetarefas.GerenciadorDeTarefasApplication;
import com.basis.colatina.gerenciadordetarefas.builder.AnexoBuilder;
import com.basis.colatina.gerenciadordetarefas.domain.Anexo;
import com.basis.colatina.gerenciadordetarefas.service.mapper.AnexoMapper;
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
public class AnexoIT extends BaseIntTest {

  @Autowired
  private AnexoBuilder builder;

  @Autowired
  private AnexoMapper anexoMapper;

  private final String URL = "/api/anexo";

  @Test
  public void storeAnexo() throws Exception {
    Anexo anexo = builder.buildEntity();
    getMockMvc().perform(post(URL)
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(anexoMapper.toDTO(anexo))))
            .andExpect(status().isCreated());
  }

}
