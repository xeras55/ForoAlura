package com.foro.api.service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.foro.api.modelo.UsuarioModelo;
import com.foro.api.modeloDto.UsuarioDTO;
import com.foro.api.repository.UsuarioRepository;
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
    UsuarioModelo usuarioModelo = usuarioRepository.findByNombre(nombre)
        .orElseThrow(() -> new UsernameNotFoundException("El usuario " + nombre + " no existe."));

    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + usuarioModelo.getRoles()));

    UserDetails userDetails = User.builder()
        .username(usuarioModelo.getNombre())
        .password(usuarioModelo.getContrasena())
        .authorities(authorities)
        .build();

    return userDetails;
  }

}
