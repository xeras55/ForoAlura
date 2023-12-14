package com.foro.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foro.api.modelo.DudaModeloNew;

@Repository
public interface DudaRepository1 extends JpaRepository<DudaModeloNew, Long> {
  List<DudaModeloNew> findById(@Param("id") long id);
}
