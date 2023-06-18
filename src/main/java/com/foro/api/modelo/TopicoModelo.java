package com.foro.api.modelo;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "topico")
@EntityListeners(AuditingEntityListener.class)
public class TopicoModelo {
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
  private boolean estatus;
  @Column
  private String autor;
  @Column
  private String curso;

  

  public TopicoModelo() {

  }
  public TopicoModelo(long id, String titulo, String mensaje, Date fecha_creacion, boolean estatus, String autor,
      String curso) {
    this.id = id;
    this.titulo = titulo;
    this.mensaje = mensaje;
    this.fecha_creacion = fecha_creacion;
    this.estatus = estatus;
    this.autor = autor;
    this.curso = curso;
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
  public boolean isestatus() {
    return estatus;
  }
  public void setestatus(boolean estatus) {
    this.estatus = estatus;
  }
  public String getAutor() {
    return autor;
  }
  public void setAutor(String autor) {
    this.autor = autor;
  }
  public String getCurso() {
    return curso;
  }
  public void setCurso(String curso) {
    this.curso = curso;
  }
  @Override
  public String toString() {
    return "TopicoModelo [id=" + id + ", titulo=" + titulo + ", mensaje=" + mensaje + ", fecha_creacion="
        + fecha_creacion + ", estatus=" + estatus + ", autor=" + autor + ", curso=" + curso + "]";
  }

  
}
