package com.foro.api.security.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foro.api.modelo.UsuarioModelo;
import com.foro.api.security.jwt.JWTUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private JWTUtils jwtUtils;

  // *constuctor
  public JwtAuthenticationFilter(JWTUtils jwtUtils) {
    this.jwtUtils = jwtUtils;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
                                              HttpServletResponse response)
                                              throws AuthenticationException {
    UsuarioModelo usuarioModelo = null;
    String nombre = "";
    String contrasena = "";

    try {
      usuarioModelo = new ObjectMapper().readValue(request.getInputStream(), UsuarioModelo.class);
      nombre = usuarioModelo.getNombre();
      contrasena = usuarioModelo.getContrasena();
    } catch (StreamReadException e) {
      throw new RuntimeException(e);
    } catch (DatabindException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nombre, contrasena);
    System.out.println(authenticationToken);
    return getAuthenticationManager().authenticate(authenticationToken);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request,
                                          HttpServletResponse response, 
                                          FilterChain chain,
                                          Authentication authResult) throws IOException, ServletException {
    User user = (User) authResult.getPrincipal();
    String token = jwtUtils.generateAccesToken(user.getUsername());

    response.addHeader("Authorization", token);

    Map<String, Object> httpResponse = new HashMap<>();
    httpResponse.put("token", token);
    httpResponse.put("Message", "La Autenticacion fue correcta");
    httpResponse.put("nombre", user.getUsername());


    response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
    response.setStatus(200);
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.getWriter().flush();
    super.successfulAuthentication(request, response, chain, authResult);
  }

}
