package com.basis.colatina.gerenciadordetarefas.service;


import com.basis.colatina.gerenciadordetarefas.domain.Responsavel;
import com.basis.colatina.gerenciadordetarefas.feing.AnexoClient;
import com.basis.colatina.gerenciadordetarefas.repository.ResponsavelRepository;
import com.basis.colatina.gerenciadordetarefas.service.dto.ResponsavelDTO;
import com.basis.colatina.gerenciadordetarefas.service.event.ResponsavelEvent;
import com.basis.colatina.gerenciadordetarefas.service.exception.RegraNegocioException;
import com.basis.colatina.gerenciadordetarefas.service.mapper.ResponsavelMapper;
import com.basis.colatina.gerenciadordetarefas.service.utils.ConstantsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResponsavelService {

  private final ResponsavelRepository responsavelRepository;
  private final ResponsavelMapper responsavelMapper;
  private final ApplicationEventPublisher applicationEventPublisher;


  public List<ResponsavelDTO> index() {
    return responsavelMapper.toDTO(responsavelRepository.findAll());
  }

  public ResponsavelDTO show(Integer id) {
    Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException(ConstantsUtils.USER_NOT_FOUND)
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
            () -> new RegraNegocioException(ConstantsUtils.USER_NOT_FOUND)
    );
    responsavelRepository.delete(responsavel);
  }

}
