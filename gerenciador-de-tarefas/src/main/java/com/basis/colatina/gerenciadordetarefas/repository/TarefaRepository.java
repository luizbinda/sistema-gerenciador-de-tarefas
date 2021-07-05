package com.basis.colatina.gerenciadordetarefas.repository;

import com.basis.colatina.gerenciadordetarefas.domain.Tarefa;
import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.TarefaDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    @Query("select new com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.TarefaDocument(" +
            "t.id," +
            "t.dataInicio," +
            "t.dataInicioPrevista," +
            "t.dataTerminoPrevista," +
            "t.status," +
            "t.comentarios," +
            "t.tipo," +
            "t.titulo," +
            "t.descricao" +
            ") from Tarefa t" +
            " where t.id = :id"
    )
    TarefaDocument getById(@Param("id") Integer id);
}
