package com.foro.api.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.api.modelo.ERole;
import com.foro.api.modelo.UsuarioModelo;
import com.foro.api.modeloDto.UsuarioDTO;
import com.foro.api.record.DatosRegistroUsuario;
import com.foro.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  @Autowired
  private UsuarioRepository usuarioRepository;


  @PostMapping("/crearUsuario")
  public UsuarioModelo usuariosByDTO(@RequestBody DatosRegistroUsuario datosRegistroUsuario){
    
    UsuarioModelo usuarioModelo = new UsuarioModelo();
    usuarioModelo.setNombre(datosRegistroUsuario.nombre());
    usuarioModelo.setEmail(datosRegistroUsuario.email());
    usuarioModelo.setContrasena(datosRegistroUsuario.contrasena());
    usuarioModelo.setRoles(datosRegistroUsuario.roles());
    return usuarioRepository.save(usuarioModelo);
    
    
  }
}
