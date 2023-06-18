package com.foro.api.modelo;

import java.sql.Date;
import java.util.List;

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
public class DudaModelo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column
  private String titulo;
  @Column
  private String mensaje;
  @Column
  private Date fecha_creacion;
  @ManyToOne
  @JoinColumn(name = "id_autor")
  private UsuarioModelo usuarioModelo;
  @ManyToOne
  @JoinColumn(name = "id_curso")
  private CursoModelo cursoModelo;
  @OneToMany(mappedBy = "dudaModelo")
  private List<RespuestaModelo> respuestaModelo;
  @Column
  private Boolean estado;

  

  public DudaModelo() {

  }
  
  
  public DudaModelo(String titulo, String mensaje, Date fecha_creacion, UsuarioModelo usuarioModelo,
      CursoModelo cursoModelo, List<RespuestaModelo> respuestaModelo, Boolean estado) {
    this.titulo = titulo;
    this.mensaje = mensaje;
    this.fecha_creacion = fecha_creacion;
    this.usuarioModelo = usuarioModelo;
    this.cursoModelo = cursoModelo;
    this.respuestaModelo = respuestaModelo;
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

  public UsuarioModelo getUsuarioModelo() {
    return usuarioModelo;
  }
  public void setUsuarioModelo(UsuarioModelo usuarioModelo) {
    this.usuarioModelo = usuarioModelo;
  }
  public CursoModelo getCursoModelo() {
    return cursoModelo;
  }
  public void setCursoModelo(CursoModelo cursoModelo) {
    this.cursoModelo = cursoModelo;
  }
  public Boolean getEstado() {
    return estado;
  }
  public void setEstado(Boolean estado) {
    this.estado = estado;
  }


  public List<RespuestaModelo> getRespuestaModelo() {
    return respuestaModelo;
  }


  public void setRespuestaModelo(List<RespuestaModelo> respuestaModelo) {
    this.respuestaModelo = respuestaModelo;
  }


  @Override
  public String toString() {
    return "DudaModelo [titulo=" + titulo + ", mensaje=" + mensaje + ", fecha_creacion=" + fecha_creacion
        + ", usuarioModelo=" + usuarioModelo + ", cursoModelo=" + cursoModelo + ", respuestaModelo=" + respuestaModelo
        + ", estado=" + estado + "]";
  }

  
}
