package com.basis.colatina.gerenciadordetarefas.service;


import com.basis.colatina.gerenciadordetarefas.domain.Responsavel;
import com.basis.colatina.gerenciadordetarefas.repository.ResponsavelRepository;
import com.basis.colatina.gerenciadordetarefas.repository.elasticsearch.ResponsavelSearchRepository;
import com.basis.colatina.gerenciadordetarefas.service.dto.ResponsavelDTO;
import com.basis.colatina.gerenciadordetarefas.service.event.ResponsavelEvent;
import com.basis.colatina.gerenciadordetarefas.service.exception.RegraNegocioException;
import com.basis.colatina.gerenciadordetarefas.service.filter.ResponsavelFilter;
import com.basis.colatina.gerenciadordetarefas.service.mapper.ResponsavelListMapper;
import com.basis.colatina.gerenciadordetarefas.service.mapper.ResponsavelMapper;
import com.basis.colatina.gerenciadordetarefas.service.utils.ConstantsUtils;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ResponsavelService {

  private final ResponsavelRepository responsavelRepository;
  private final ResponsavelSearchRepository responsavelSearchRepository;
  private final ResponsavelMapper responsavelMapper;
  private final ResponsavelListMapper responsavelListMapper;
  private final ApplicationEventPublisher applicationEventPublisher;


  public Page<ResponsavelDTO> index(ResponsavelFilter filter, Pageable pageable) {
    return responsavelSearchRepository.search(filter.getFilter(), pageable).map(responsavelListMapper::toDTO);
  }

  public ResponsavelDTO show(Integer id) {
    Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException(ConstantsUtils.RESPONSAVEL_NOT_FOUND)
    );
    return responsavelMapper.toDTO(responsavel);
  }

  public ResponsavelDTO save(ResponsavelDTO reponsavelDTO) {
    Responsavel responsavel = responsavelMapper.toEntity(reponsavelDTO);
    responsavelRepository.save(responsavel);
    applicationEventPublisher.publishEvent(new ResponsavelEvent(responsavel.getId()));
    return responsavelMapper.toDTO(responsavel);
  }

  public void delete(Integer id) {
    Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException(ConstantsUtils.RESPONSAVEL_NOT_FOUND)
    );
    responsavelRepository.delete(responsavel);
  }

}
