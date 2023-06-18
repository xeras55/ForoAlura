package com.foro.api.modelo;

import java.sql.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "respuesta")
@EntityListeners(AuditingEntityListener.class)
public class RespuestaModelo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column
  private String mensaje_res;

  @ManyToOne
  @JoinColumn(name = "id_duda")
  private DudaModelo dudaModelo;
  @Column
  private Date fecha_creacion;
  @Column
  private long id_usuario;
  @Column
  private Boolean solucion;

  
  public RespuestaModelo() {
    
  }
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getMensaje_res() {
    return mensaje_res;
  }
  public void setMensaje_res(String mensaje_res) {
    this.mensaje_res = mensaje_res;
  }
  
  public Date getFecha_creacion() {
    return fecha_creacion;
  }
  public void setFecha_creacion(Date fecha_creacion) {
    this.fecha_creacion = fecha_creacion;
  }
  public long getId_usuario() {
    return id_usuario;
  }
  public void setId_usuario(long id_usuario) {
    this.id_usuario = id_usuario;
  }
  public Boolean getSolucion() {
    return solucion;
  }
  public void setSolucion(Boolean solucion) {
    this.solucion = solucion;
  }
  public DudaModelo getDudaModelo() {
    return dudaModelo;
  }
  public void setDudaModelo(DudaModelo dudaModelo) {
    this.dudaModelo = dudaModelo;
  }

  
}
