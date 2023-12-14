package com.foro.api.modeloDto;

import com.foro.api.modelo.UsuarioModelo;

public class UsuarioDTO {

  /*
   * Clases para filtrar los datos que se envian desde la base de datos
   */
  private UsuarioModelo usuarioModelo;

  public UsuarioDTO(UsuarioModelo usuarioModelo) {
    this.usuarioModelo = usuarioModelo;
  }

  private String nombre;
  private String email;
  private String contrasena;
  private String roles;

  public UsuarioDTO() {

  }

  public UsuarioDTO(String nombre, String email, String contrasena, String roles) {
    this.nombre = nombre;
    this.email = email;
    this.contrasena = contrasena;
    this.roles = roles;
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
