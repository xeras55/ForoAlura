package com.foro.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.api.modelo.TopicoModelo;
import com.foro.api.repository.TopicoRepository;

@RestController
@RequestMapping("/topico")
public class TopicoController {
  
  @Autowired
  private TopicoRepository topicoRepository;

  @GetMapping("/topicof")
  public List<TopicoModelo>allModelo(){
    return topicoRepository.findAll();
  }
  @GetMapping("/topicoF/{id}")
  public List<TopicoModelo>findById(@PathVariable("id") long id){
    return topicoRepository.findById(id);
  }
  @PostMapping("/registrart")
  public TopicoModelo createModelo(@RequestBody TopicoModelo topicoModelo){
    return topicoRepository.save(topicoModelo);
  }
  @PutMapping("/actualizart/{id}")
  public TopicoModelo updateTopico(@PathVariable("id") long id, @RequestBody TopicoModelo topicoModelo){
        topicoModelo.setId(id);
    return topicoRepository.save(topicoModelo);
  }
  @DeleteMapping("/deletet/{id}")
  public void deleteTopico(@PathVariable("id")long id){
    topicoRepository.deleteById(id);
  }
}
