package com.foro.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foro.api.modelo.TopicoModelo;

@Repository
public interface TopicoRepository extends JpaRepository<TopicoModelo, Long> {
  List<TopicoModelo>findById(@Param("id")long id);
  
}
