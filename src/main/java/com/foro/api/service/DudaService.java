package com.foro.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foro.api.modelo.CursoModelo;
import com.foro.api.modelo.DudaModelo;
import com.foro.api.modelo.UsuarioModelo;
import com.foro.api.modeloDto.DudaDTO;
import com.foro.api.repository.DudaRepository;

@Service
public class DudaService {

  @Autowired
  private DudaRepository dudaRepository;

  private List<DudaDTO> getDudas(Long id) {
    List<Object[]> result = dudaRepository.findDudaDataById(id);
    List<DudaModelo> dudasM = new ArrayList<>();
    List<DudaDTO> dudasDto = new ArrayList<>();

    for (DudaModelo dudas : dudasM) {
      DudaDTO dudaDTO = convertEntityToDto(dudas);
      dudasDto.add(dudaDTO);
    }
    return dudasDto;

  }

  private DudaDTO convertEntityToDto(DudaModelo dudas) {
    DudaDTO dudaDTO = new DudaDTO();
    dudaDTO.setTitulo(dudas.getTitulo());
    dudaDTO.setMensaje(dudas.getMensaje());
    dudaDTO.setFecha_creacion(dudas.getFecha_creacion());
    UsuarioModelo usuario = new UsuarioModelo();
    dudaDTO.setAutor_nombre(usuario.getNombre());
    CursoModelo curso = new CursoModelo();
    dudaDTO.setCurso_nombre(curso.getNombre());
    dudaDTO.setStatus(dudas.getEstado());
    return dudaDTO;
  }
}
