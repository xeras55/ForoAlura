
package com.foro.api.security.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.lang.NonNull;

import com.foro.api.modelo.UsuarioModelo;
import com.foro.api.repository.UsuarioRepository;
import com.foro.api.security.jwt.JWTUtils;
import com.foro.api.service.CustomUserDetailsServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter{

  @Autowired
  private JWTUtils jwtUtils;

  @Autowired
  private CustomUserDetailsServiceImpl userDetailsService;

  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request,
                                  @NonNull HttpServletResponse response,
                                  @NonNull FilterChain filterChain)throws ServletException, IOException {

    String tokeHeader = request.getHeader("Authorization");
    
    if(tokeHeader != null && tokeHeader.startsWith("Bearer ")){
      String token = tokeHeader.substring(7);
      
      if(jwtUtils.isTokenValid(token)){
        String nombre = jwtUtils.getUsernameFromToken(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(nombre);

        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(nombre, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    }
    filterChain.doFilter(request, response);
  }



  
  
}
