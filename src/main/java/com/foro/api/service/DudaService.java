package com.foro.api.service;

import java.sql.Date;
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

  @Autowired private DudaRepository dudaRepository;

  /*
  public List<DudaModelo>dudaModelos(){
    List<Object[]> result = dudaRepository.getAll();
    List<DudaModelo> dudas = new ArrayList<>();
    for(Object[] row : result){
      DudaModelo duda = new DudaModelo();
            duda.setTitulo((String) row[0]);
      duda.setMensaje((String) row[1]);
      duda.setFecha_creacion((Date) row[2]);
      duda.setEstado((Boolean) row[3]);
      UsuarioModelo usuario = new UsuarioModelo();
      usuario.setNombre((String) row[4]);
      duda.setUsuarioModelo(usuario);
      CursoModelo curso = new CursoModelo();
      curso.setNombre((String) row[5]);
      duda.setCursoModelo(curso);
      dudas.add(duda);
    }
    
    return dudas;
  }
 */
  private List<DudaDTO>getDudas(Long id){
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
