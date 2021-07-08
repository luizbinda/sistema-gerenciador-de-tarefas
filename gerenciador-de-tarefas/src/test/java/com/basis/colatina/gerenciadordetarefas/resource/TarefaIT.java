package com.basis.colatina.gerenciadordetarefas.resource;

import com.basis.colatina.gerenciadordetarefas.GerenciadorDeTarefasApplication;
import com.basis.colatina.gerenciadordetarefas.builder.TarefaBuilder;
import com.basis.colatina.gerenciadordetarefas.domain.Tarefa;
import com.basis.colatina.gerenciadordetarefas.service.mapper.TarefaMapper;
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
public class TarefaIT extends BaseIntTest {

  @Autowired
  private TarefaBuilder builder;

  @Autowired
  private TarefaMapper tarefaMapper;

  private final String URL = "/api/tarefa";

  @Test
  public void storeTarefa() throws Exception {
    Tarefa tarefa = builder.buildEntity();
    getMockMvc().perform(post(URL)
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tarefaMapper.toDTO(tarefa))))
            .andExpect(status().isCreated());
  }

}
