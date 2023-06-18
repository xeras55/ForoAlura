package com.foro.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foro.api.modelo.DudaModelo;




@Repository
public interface DudaRepository extends JpaRepository<DudaModelo, Long> {
  @Query("SELECT duda.titulo, duda.mensaje, duda.fecha_creacion, duda.estado, usuario.nombre AS nombreUsuario, curso.nombre AS nombreCurso "
      +
      "FROM DudaModelo duda " +
      "INNER JOIN duda.usuarioModelo usuario " +
      "INNER JOIN duda.cursoModelo curso " +
      "WHERE duda.id = :id")
  List<Object[]> findDudaDataById(@Param("id") Long id);
}

/*
@Repository
public interface DudaRepository extends JpaRepository<DudaModelo, Long> {
  @Query("SELECT duda.titulo, duda.mensaje, duda.fecha_creacion, duda.estado, usuario.nombre AS nombreUsuario, curso.nombre AS nombreCurso "
      +
      "FROM DudaModelo duda " +
      "INNER JOIN duda.usuarioModelo usuario " +
      "INNER JOIN duda.cursoModelo curso " +
      "WHERE duda.id = :id")
  Optional<DudaModelo> findById(@Param("id") Long id);
}
 */
/*
@Repository
public interface DudaRepository extends JpaRepository<DudaModelo, Long> {
  @Query("SELECT duda.titulo, duda.mensaje, duda.fechaCreacion, duda.estado, usuario.nombre AS nombreUsuario, curso.nombre AS nombreCurso "
      +
      "FROM DudaModelo duda " +
      "INNER JOIN duda.usuario usuario " +
      "INNER JOIN duda.respuestas respuesta " +
      "INNER JOIN duda.curso curso " +
      "WHERE duda.id = :id")
  List<Object[]> findDudaDataById(@Param("id") Long id);
} 
 */
/*
@Repository
public interface DudaRepository extends JpaRepository<DudaModelo, Long> {
  @Query("SELECT duda.titulo, duda.mensaje, duda.fechaCreacion, duda.estado, usuario.nombre AS nombreUsuario, curso.nombre AS nombreCurso "
      +
      "FROM Duda duda " +
      "INNER JOIN duda.usuario usuario " +
      "INNER JOIN duda.respuestas respuesta " +
      "INNER JOIN duda.curso curso " +
      "WHERE duda.id = :id")
  List<Object[]> findDudaDataById(@Param("id") Long id);
}
   */



