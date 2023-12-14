package com.foro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.api.modelo.DudaModeloNew;
import com.foro.api.repository.DudaRepository1;

@RestController
@RequestMapping("/newDuda")
public class DudaControllerNew {
  @Autowired
  private DudaRepository1 dudaRepository1;

  /*
   * Con el método post se envían los datos al servidor para generar una
   * publicación de una nueva "Duda", pero primero se valida que todos los datos
   * sean ingresados correctamente.
   * De igual forma se valida si se genera algún error al momento de mandar la
   * información con un try catch
   */

  /**
   * TODO (mejorar la validacion de datos)
   */
  @PostMapping("/newD")
  public ResponseEntity<Object> createDuda(@RequestBody DudaModeloNew dudaModeloNew) {
    Long id_autor = dudaModeloNew.getId_autor();
    Long id_curso = dudaModeloNew.getId_curso();
    if (dudaModeloNew.getTitulo() == null || dudaModeloNew.getTitulo().isEmpty() ||
        dudaModeloNew.getMensaje() == null || dudaModeloNew.getMensaje().isEmpty() ||
        dudaModeloNew.getFecha_creacion() == null ||
        id_autor == null || id_curso == null ||
        dudaModeloNew.getRespuestas() == null || dudaModeloNew.getRespuestas().isEmpty() ||
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

  /*
   * Con el método put mandamos una actualización a la base de datos para cambiar
   * el dato que se haya necesitado actualizar dependiendo del id usado como
   * parámetro, de igual forma se valida con un try catch si se puede generar
   * algún error durante el proceso
   */
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
   * Con el método Delete mandamos una petición para buscar al usuario por su ID,
   * y se elimina su información
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

}
