package com.foro.api.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestControler {


  @GetMapping("/TestAdmin")
  public String accesAdmin(){
    return "Acceso con admin";
  }


    @GetMapping("/TestUser")
  public String accessUser(){
    return "Acceso con user";
  }


    @GetMapping("/TestInvited")
  public String accesIvited(){
    return "Acceso con invited";
  }
}
