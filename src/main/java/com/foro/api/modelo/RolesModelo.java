package com.foro.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class RolesModelo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private ERole nombre;

  public RolesModelo() {

  }

  public RolesModelo(Long id, ERole nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ERole getNombre() {
    return nombre;
  }

  public void setNombre(ERole nombre) {
    this.nombre = nombre;
  }

}
