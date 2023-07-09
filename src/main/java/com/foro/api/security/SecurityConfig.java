package com.foro.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.foro.api.security.filters.JwtAuthenticationFilter;
import com.foro.api.security.filters.JwtAuthorizationFilter;
import com.foro.api.security.jwt.JWTUtils;
import com.foro.api.service.CustomUserDetailsServiceImpl;

@Configuration
public class SecurityConfig  {
  
  @Autowired 
  JWTUtils jwtUtils;

  @Autowired
  CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

  @Autowired
  JwtAuthorizationFilter authorizationFilter;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception{

    JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
    jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
    jwtAuthenticationFilter.setFilterProcessesUrl("/login");

    return http
          .csrf(config -> config.disable())
          .authorizeHttpRequests(auth ->{
            auth.requestMatchers("/duda/dudaAll").hasAnyRole("ADMIN", "USER", "INVITED");
            auth.requestMatchers("/duda//dudaByIdDto/{id}").hasAnyRole("ADMIN", "USER", "INVITED");
            auth.requestMatchers("/newDuda/newD").hasAnyRole("ADMIN", "USER");
            auth.requestMatchers("/newDuda/actualizarDuda/{id}").hasAnyRole("ADMIN", "USER");
            auth.requestMatchers("/newDuda/deletDuda/{id}").hasAnyRole("ADMIN", "USER");
            auth.requestMatchers("/topico/topicof").hasAnyRole("ADMIN", "USER","INVITED");
            auth.requestMatchers("/newDuda/newD").hasAnyRole("ADMIN", "USER","INVITED");

            auth.anyRequest().authenticated();
          })
          .sessionManagement(session ->{
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
          })
          .addFilter(jwtAuthenticationFilter)
          .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
          .build();
  }

  /*
@Bean
  UserDetailsService userDetailsService(){
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("geras")
            .password("123456")
            .roles()
            .build());

    return manager;
  }
 */
  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
    //return NoOpPasswordEncoder.getInstance();
  }

  @Bean
  AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception{
    return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
    .userDetailsService(customUserDetailsServiceImpl)
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


/*
  public static void main(String[] args) {
    

String password = "1234";
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

String hashedPassword = encoder.encode(password);
System.out.println(hashedPassword);

  }
   */
}
