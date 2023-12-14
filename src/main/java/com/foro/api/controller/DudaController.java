package com.foro.api.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.api.modelo.CursoModelo;
import com.foro.api.modelo.DudaModelo;
import com.foro.api.modelo.UsuarioModelo;
import com.foro.api.modeloDto.DudaDTO;
import com.foro.api.repository.DudaRepository;

@RestController
@RequestMapping("/duda")
public class DudaController {
  @Autowired
  private DudaRepository dudaRepository;

  /*
   * Usamos un objeto de tipo DudaModelo para poder usar sus atributos y rellenar
   * los datos que se necesiten mandar como respuesta.
   */

  /*
   * Obtenemos todas las "Dudas" posteadas
   */
  @GetMapping("/dudaAll")
  public ResponseEntity<Object> obtenerDudas() {
    try {
      List<Object[]> result = dudaRepository.getAll();
      List<DudaModelo> dudas = new ArrayList<>();

      for (Object[] row : result) {
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

      return ResponseEntity.ok(dudas);
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error al obtener las dudas");
    }
  }

  // *Retorna datos inecesariios
  @GetMapping("/dudaById/{id}")
  public List<DudaModelo> dudasById(@PathVariable("id") Long id) {
    List<Object[]> result = dudaRepository.findDudaDataById(id);
    List<DudaModelo> dudas = new ArrayList<>();
    for (Object[] row : result) {
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

  /*
   * Se filtran la busqueda por medio del id
   * Usamos un objeto de tipo DudaDTO para poder filtrar y rellenar los datos que
   * se necesiten mandar como respuesta, y no mandar información de más.
   */
  @GetMapping("/dudaByIdDto/{id}")
  public ResponseEntity<Object> obtenerDudasByIdDto(@PathVariable("id") Long id) {
    List<Object[]> result = dudaRepository.findDudaDataById(id);
    if (result.isEmpty()) {
      return ResponseEntity.status(404).body("El id ingresado es invalido");
    }
    try {
      List<DudaDTO> dudasDto = new ArrayList<>();

      for (Object[] row : result) {
        DudaDTO duda = new DudaDTO();
        duda.setTitulo((String) row[0]);
        duda.setMensaje((String) row[1]);
        duda.setFecha_creacion((Date) row[2]);
        duda.setStatus((Boolean) row[3]);
        UsuarioModelo usuario = new UsuarioModelo();
        usuario.setNombre((String) row[4]);
        String nombreUsua = usuario.getNombre();
        duda.setAutor_nombre(nombreUsua);
        CursoModelo curso = new CursoModelo();
        curso.setNombre((String) row[5]);
        String cursoNombre = curso.getNombre();
        duda.setCurso_nombre(cursoNombre);
        dudasDto.add(duda);
      }

      return ResponseEntity.ok(dudasDto);
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error al obtener las dudas por ID");
    }
  }

}
