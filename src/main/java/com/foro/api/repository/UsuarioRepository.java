package com.foro.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foro.api.modelo.UsuarioModelo;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModelo, Long>{
  Optional<UsuarioModelo> findByNombre(String nombre);
}
