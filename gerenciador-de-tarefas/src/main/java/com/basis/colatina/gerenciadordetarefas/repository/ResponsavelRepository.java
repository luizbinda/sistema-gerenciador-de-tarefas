package com.basis.colatina.gerenciadordetarefas.repository;

import com.basis.colatina.gerenciadordetarefas.domain.Responsavel;
import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.ResponsavelDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {

  @Query("select new com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.ResponsavelDocument(" +
          "r.id," +
          "r.dataNascimento," +
          "r.email," +
          "r.nome," +
          "r.status" +
          ") from Responsavel r" +
          " where r.id = :id"
  )
  ResponsavelDocument getById(@Param("id") Integer id);
}
