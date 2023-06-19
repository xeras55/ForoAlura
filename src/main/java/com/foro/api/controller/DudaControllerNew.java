package com.foro.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.api.modelo.DudaModeloNew;
import com.foro.api.repository.DudaRepository;
import com.foro.api.repository.DudaRepository1;

@RestController
@RequestMapping("/newDuda")
public class DudaControllerNew {
  @Autowired
  private DudaRepository1 dudaRepository1;


  @PostMapping("/newD")
  public DudaModeloNew createDuda(@RequestBody DudaModeloNew dudaModeloNew){
    return dudaRepository1.save(dudaModeloNew);
  }

  @PutMapping("/actualizarDuda/{id}")
  public DudaModeloNew updateDuda(@PathVariable("id") long id, @RequestBody DudaModeloNew dudaModeloNew){
    dudaModeloNew.setId(id);
    return dudaRepository1.save(dudaModeloNew);
    
  }

}
