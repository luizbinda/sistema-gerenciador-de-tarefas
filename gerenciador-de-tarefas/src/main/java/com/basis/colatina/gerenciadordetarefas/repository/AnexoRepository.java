package com.basis.colatina.gerenciadordetarefas.repository;

import com.basis.colatina.gerenciadordetarefas.domain.Anexo;
import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.AnexoDocument;
import com.basis.colatina.gerenciadordetarefas.repository.elasticsearch.Reindexer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnexoRepository extends JpaRepository<Anexo, Integer>, Reindexer {

    @Query("select new com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.AnexoDocument(" +
            "a.id," +
            "a.hash," +
            "a.tipo," +
            "a.titulo," +
            "a.tamanho," +
            "a.tarefa.descricao" +
            ") from Anexo a" +
            " where a.id = :id"
    )
    AnexoDocument getById(@Param("id") Integer id);


    @Override
    @Query("select new com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.AnexoDocument(" +
            "a.id," +
            "a.hash," +
            "a.tipo," +
            "a.titulo," +
            "a.tamanho," +
            "a.tarefa.descricao" +
            ") from Anexo a ORDER BY a.id"
    )
    Page<AnexoDocument> reindexPage(Pageable pageable);

    @Override
    default String getEntity() {
        return "anexo";
    }

}
