package com.foro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.api.modelo.UsuarioModelo;
import com.foro.api.record.DatosRegistroUsuario;
import com.foro.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  /*
   * Para poder crear un usuario nuevo, primero se valida que toda la información
   * se esté enviando correctamente, basándonos en un objeto de la clase
   * DatosRegistroUsuario. Después, se usa un objeto de la clase UsuarioModelo
   * para añadir los parámetros. Por último, se usa un bloque try-catch para
   * validar que no haya ningún error o inconveniente al momento de mandar la
   * información.
   */

  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UsuarioRepository usuarioRepository;

  @PostMapping("/crearUsuario")
  public ResponseEntity<Object> usuariosByDTO(@RequestBody DatosRegistroUsuario datosRegistroUsuario) {
    if (datosRegistroUsuario.nombre() == null || datosRegistroUsuario.nombre().isEmpty()
        || datosRegistroUsuario.email() == null || datosRegistroUsuario.email().isEmpty()
        || datosRegistroUsuario.contrasena() == null || datosRegistroUsuario.contrasena().isEmpty()) {
      return ResponseEntity.badRequest().body("Los campos 'nombre', 'email' y 'contrasena' son requeridos");
    }

    try {
      UsuarioModelo usuarioModelo = new UsuarioModelo();
      usuarioModelo.setNombre(datosRegistroUsuario.nombre());
      usuarioModelo.setEmail(datosRegistroUsuario.email());
      usuarioModelo.setContrasena(passwordEncoder.encode(datosRegistroUsuario.contrasena()));
      usuarioModelo.setRoles(datosRegistroUsuario.roles().toString());

      UsuarioModelo usuarioGuardado = usuarioRepository.save(usuarioModelo);
      return ResponseEntity.ok(usuarioGuardado);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el usuario");
    }
  }

}
