package com.basis.colatina.gerenciadordetarefas.service;

import com.basis.colatina.gerenciadordetarefas.domain.Anexo;
import com.basis.colatina.gerenciadordetarefas.feing.AnexoClient;
import com.basis.colatina.gerenciadordetarefas.repository.AnexoRepository;
import com.basis.colatina.gerenciadordetarefas.service.dto.AnexoDTO;
import com.basis.colatina.gerenciadordetarefas.service.exception.RegraNegocioException;
import com.basis.colatina.gerenciadordetarefas.service.mapper.AnexoMapper;
import com.basis.colatina.gerenciadordetarefas.service.utils.ConstantsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnexoService {

  private final AnexoRepository anexoRepository;
  private final AnexoMapper anexoMapper;
  private final AnexoClient anexoClient;

  public List<AnexoDTO> index() {
    anexoClient.getAnexo();
    return anexoMapper.toDTO(anexoRepository.findAll());
  }

  public AnexoDTO show(Integer id) {
    Anexo anexo = anexoRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException(ConstantsUtils.USER_NOT_FOUND)
    );
    return anexoMapper.toDTO(anexo);
  }

  public AnexoDTO save(AnexoDTO anexoDTO) {
    Anexo anexo = anexoMapper.toEntity(anexoDTO);
    anexoClient.uploadAnexo(anexoDTO);
    return anexoMapper.toDTO(anexo);
  }

  public void delete(Integer id) {
    Anexo anexo = anexoRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException(ConstantsUtils.USER_NOT_FOUND)
    );
    anexoRepository.delete(anexo);
  }

}
