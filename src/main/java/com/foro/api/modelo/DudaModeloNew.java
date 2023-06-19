package com.foro.api.modelo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "duda")
@EntityListeners(AuditingEntityListener.class)
public class DudaModeloNew {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column
  private String titulo;
  @Column
  private String mensaje;
  @Column
  @CreatedDate
  private Date fecha_creacion;
  @Column
  private long id_autor;
  @Column
  private long id_curso;
  @Column
  private String respuestas;
  @Column
  private Boolean estado;


  
  
  
  public DudaModeloNew() {

  }
  


  public DudaModeloNew(String titulo, String mensaje) {
    this.titulo = titulo;
    this.mensaje = mensaje;
  }



  public DudaModeloNew(String titulo, String mensaje, Date fecha_creacion, long id_autor, long id_curso,
      String respuestas, Boolean estado) {
    this.titulo = titulo;
    this.mensaje = mensaje;
    this.fecha_creacion = fecha_creacion;
    this.id_autor = id_autor;
    this.id_curso = id_curso;
    this.respuestas = respuestas;
    this.estado = estado;
  }



  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  public String getMensaje() {
    return mensaje;
  }
  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }
  public Date getFecha_creacion() {
    return fecha_creacion;
  }
  public void setFecha_creacion(Date fecha_creacion) {
    this.fecha_creacion = fecha_creacion;
  }
  public long getId_autor() {
    return id_autor;
  }
  public void setId_autor(long id_autor) {
    this.id_autor = id_autor;
  }
  public long getId_curso() {
    return id_curso;
  }
  public void setId_curso(long id_curso) {
    this.id_curso = id_curso;
  }
  public String getRespuestas() {
    return respuestas;
  }
  public void setRespuestas(String respuestas) {
    this.respuestas = respuestas;
  }
  public Boolean getEstado() {
    return estado;
  }
  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  
}
