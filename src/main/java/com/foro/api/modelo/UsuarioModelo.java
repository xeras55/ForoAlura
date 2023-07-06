package com.foro.api.modelo;

import java.util.Set;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.foro.api.modeloDto.UsuarioDTO;
import com.foro.api.record.DatosRegistroUsuario;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
public class UsuarioModelo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Column
  private String nombre;
  @Column
  
  private String email;
  @Column 
  private String contrasena;
  @Column
  private String roles;
  
  //*se usa un Set ya que no permite item repetidos


  
  public UsuarioModelo(DatosRegistroUsuario datosRegistroUsuario) {
    this.nombre = datosRegistroUsuario.nombre();
    this.email = datosRegistroUsuario.email();
    this.contrasena = datosRegistroUsuario.contrasena();
    this.roles = datosRegistroUsuario.roles().toString();
  }
  


  public UsuarioModelo(UsuarioDTO usuarioDTO) {
  }



  public UsuarioModelo(String nombre) {
    this.nombre = nombre;
  }

  public UsuarioModelo() {
  }


  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getContrasena() {
    return contrasena;
  }
  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }


  public String getRoles() {
    return roles;
  }


  public void setRoles(String roles) {
    this.roles = roles;
  }


  
}
