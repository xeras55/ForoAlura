package com.foro.api.modeloDto;

import java.sql.Date;

public class DudaDTO {
  private String titulo;
  private String mensaje;
  private Date fecha_creacion;
  private String autor_nombre;
  private String curso_nombre;
  private String status;
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
  public String getAutor_nombre() {
    return autor_nombre;
  }
  public void setAutor_nombre(String autor_nombre) {
    this.autor_nombre = autor_nombre;
  }
  public String getCurso_nombre() {
    return curso_nombre;
  }
  public void setCurso_nombre(String curso_nombre) {
    this.curso_nombre = curso_nombre;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  
}
