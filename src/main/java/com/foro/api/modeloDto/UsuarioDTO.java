package com.foro.api.modeloDto;

import java.util.Set;

import jakarta.persistence.Column;

public class UsuarioDTO {

  private String nombre;
  private String email;
  private String contrasena;
  private Set<String> roles;

  public UsuarioDTO() {

  }

  public UsuarioDTO(String nombre, String email, String contrasena, Set<String> roles) {
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

  public Set<String> getRoles() {
    return roles;
  }

  public void setRoles(Set<String> roles) {
    this.roles = roles;
  }

}
