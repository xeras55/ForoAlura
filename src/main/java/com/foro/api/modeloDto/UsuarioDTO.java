package com.foro.api.modeloDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.foro.api.modelo.RolesModelo;
import com.foro.api.modelo.UsuarioModelo;
import com.foro.api.repository.UsuarioRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


public class UsuarioDTO {

  

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

  /*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = usuarioModelo.getRoles();
        

        List<GrantedAuthority> authorities = Collections.singletonList(
          new SimpleGrantedAuthority(roles));

  return authorities;
}

  @Override
  public String getPassword() {
    return contrasena;
  }

  @Override
  public String getUsername() {
    return nombre;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  } */

}
