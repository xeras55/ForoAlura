package com.foro.api.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.api.modelo.CursoModelo;
import com.foro.api.modelo.DudaModelo;
import com.foro.api.modelo.UsuarioModelo;
import com.foro.api.repository.DudaRepository;



@RestController
@RequestMapping("/duda")
public class DudaController {
  @Autowired
  private DudaRepository dudaRepository;
  /*
  @GetMapping("/dudaAll/{id}")
  public Optional<DudaModelo> dudasById(@PathVariable("id") long id){
    return dudaRepository.findById(id);
  }
   */ 
  @GetMapping("/dudaAll/{id}")
  public List<DudaModelo>dudasById(@PathVariable("id") Long id){
    List<Object[]>result = dudaRepository.findDudaDataById(id);
    List<DudaModelo>dudas = new ArrayList<>();
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
}
