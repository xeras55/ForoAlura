package com.foro.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.api.modelo.DudaModeloNew;
import com.foro.api.repository.DudaRepository;
import com.foro.api.repository.DudaRepository1;

@RestController
@RequestMapping("/newDuda")
public class DudaControllerNew {
  @Autowired
  private DudaRepository1 dudaRepository1;

/*
  @PostMapping("/newD")
  public DudaModeloNew createDuda(@RequestBody DudaModeloNew dudaModeloNew){
    return dudaRepository1.save(dudaModeloNew);
  }
 */
  @PostMapping("/newD")
public ResponseEntity<Object> createDuda(@RequestBody DudaModeloNew dudaModeloNew) {
  Long id_autor = dudaModeloNew.getId_autor();
  Long id_curso = dudaModeloNew.getId_curso();
  if (dudaModeloNew.getTitulo()== null || dudaModeloNew.getTitulo().isEmpty()  ||
      dudaModeloNew.getMensaje()== null || dudaModeloNew.getMensaje().isEmpty()||
      dudaModeloNew.getFecha_creacion() == null ||
      id_autor ==  null || id_curso == null ||
      dudaModeloNew.getRespuestas() == null ||dudaModeloNew.getRespuestas().isEmpty() ||
      dudaModeloNew.getEstado() == null) {
        return ResponseEntity.badRequest().body("Revisa que hayas ingresado todos los datos");
  }
  try {
    DudaModeloNew dudaGuardada = dudaRepository1.save(dudaModeloNew);
    return ResponseEntity.ok(dudaGuardada);
  } catch (Exception e) {
    return ResponseEntity.status(500).body("Error al crear la duda");
  }
}

@PutMapping("/actualizarDuda/{id}")
public ResponseEntity<Object> updateDuda(@PathVariable("id") long id, @RequestBody DudaModeloNew dudaModeloNew) {
  try {
    if (!dudaRepository1.existsById(id)) {
      return ResponseEntity.badRequest().body("La duda con el ID " + id + " no existe");
    }
    dudaModeloNew.setId(id);
    DudaModeloNew dudaActualizada = dudaRepository1.save(dudaModeloNew);
    return ResponseEntity.ok(dudaActualizada);
  } catch (Exception e) {
    return ResponseEntity.status(500).body("Error al actualizar la duda");
  }
}


/*
  @PutMapping("/actualizarDuda/{id}")
  public DudaModeloNew updateDuda(@PathVariable("id") long id, @RequestBody DudaModeloNew dudaModeloNew){
    dudaModeloNew.setId(id);
    return dudaRepository1.save(dudaModeloNew);
    
  }
   */


  @DeleteMapping("/deletDuda/{id}")
public ResponseEntity<Object> deleteDuda(@PathVariable("id") long id) {
  try {
    dudaRepository1.deleteById(id);
    return ResponseEntity.ok().build();
  } catch (EmptyResultDataAccessException e) {
    return ResponseEntity.status(400).body("La duda con el ID " + id + " no existe");
  } catch (Exception e) {
    return ResponseEntity.status(500).body("Error al eliminar la duda");
  }
}

/*
  @DeleteMapping("/deletDuda/{id}")
  public void deleteDuda(@PathVariable("id")long id){
    dudaRepository1.deleteById(id);
  }
 */
}
