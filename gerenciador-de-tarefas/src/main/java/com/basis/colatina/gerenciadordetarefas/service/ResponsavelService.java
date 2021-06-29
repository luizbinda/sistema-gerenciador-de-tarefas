package com.basis.colatina.gerenciadordetarefas.service;


import com.basis.colatina.gerenciadordetarefas.repository.ResponsavelRepository;
import com.basis.colatina.gerenciadordetarefas.service.dto.ResponsavelDTO;
import com.basis.colatina.gerenciadordetarefas.service.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResponsavelService {

  private final ResponsavelRepository responsavelRepository;
  private final ResponsavelMapper responsavelMapper;

  public List<ResponsavelDTO> index() {
    return null;
  }

  public ResponsavelDTO show() {
    return null;
  }

  public ResponsavelDTO save(ResponsavelDTO reponsavelDTO) {
//    Responsavel res = responsavelMapper.toEntity(reponsavelDTO);
    return null;
  }

}
