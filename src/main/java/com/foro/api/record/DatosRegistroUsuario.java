package com.foro.api.record;

import java.util.Set;

import com.foro.api.modelo.ERole;

public record DatosRegistroUsuario(
    String nombre,
    String email,
    String contrasena,
    ERole roles) {

}
