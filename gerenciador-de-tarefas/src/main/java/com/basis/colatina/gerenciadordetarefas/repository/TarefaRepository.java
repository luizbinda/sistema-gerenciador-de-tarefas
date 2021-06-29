package com.basis.colatina.gerenciadordetarefas.repository;

import com.basis.colatina.gerenciadordetarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
