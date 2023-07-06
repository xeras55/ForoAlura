package com.foro.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig  {
  
  


  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    return http
          .csrf(config -> config.disable())
          .authorizeHttpRequests(auth ->{
            auth.requestMatchers("/duda/dudaAll").permitAll();
            auth.requestMatchers("/usuarios/crearUsuario").permitAll();
            auth.anyRequest().authenticated();
          })
          .sessionManagement(session ->{
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
          })
          .httpBasic(httpbasic ->{})
          .build();
  }
@Bean
  UserDetailsService userDetailsService(){
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("geras")
            .password("123456")
            .roles()
            .build());

    return manager;
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return NoOpPasswordEncoder.getInstance();
  }


  AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception{
    return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
    .userDetailsService(userDetailsService())
    .passwordEncoder(passwordEncoder)
    .and().build();
    
  }

/*
    @Bean
  SecurityFilterChain filterChain1(HttpSecurity http, AuthenticationManager authManager) throws Exception{
    return http
    .csrf().disable()
    .authorizeRequests()
    .anyRequest()
    .authenticated()
    .and()
    .httpBasic()
    .and()
    .sessionManagement()
    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and()
    .build();
    
  }
 */
  
}
