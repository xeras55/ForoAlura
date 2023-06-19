package com.foro.api.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foro.api.modelo.DudaModelo;
import com.foro.api.modelo.DudaModeloNew;




@Repository
public interface DudaRepository extends JpaRepository<DudaModelo, Long> {
  @Query("SELECT duda.titulo, duda.mensaje, duda.fecha_creacion, duda.estado, usuario.nombre AS nombreUsuario, curso.nombre AS nombreCurso "
      +
      "FROM DudaModelo duda " +
      "INNER JOIN duda.usuarioModelo usuario " +
      "INNER JOIN duda.cursoModelo curso " +
      "WHERE duda.id = :id")
  List<Object[]> findDudaDataById(@Param("id") Long id);

  @Query("SELECT duda.titulo, duda.mensaje, duda.fecha_creacion, duda.estado, usuario.nombre AS nombreUsuario, curso.nombre AS nombreCurso "
      +
      "FROM DudaModelo duda " +
      "INNER JOIN duda.usuarioModelo usuario " +
      "INNER JOIN duda.cursoModelo curso ")
  List<Object[]>getAll();

  /*
  @Modifying
  @Query(value = "INSERT INTO duda (titulo, mensaje, fecha_creacion, id_autor, id_curso, respuestas) VALUES (:titulo, :mensaje, :fecha_creacion, :id_autor, :id_curso, :respuestas)", nativeQuery = true)
  DudaModeloNew insertDuda(@Param("titulo") String titulo,
                  @Param("mensaje") String mensaje,
                  @Param("fecha_creacion") Date fecha_creacion,
                  @Param("id_autor") Long id_autor,
                  @Param("id_curso") Long id_curso,
                  @Param("respuestas") String respuestas);
 */
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



