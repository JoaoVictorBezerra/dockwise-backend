package com.api.containers.controller;

import com.api.containers.controller.advice.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AppController {
  private final Response apiOk = new Response("API Funcionando", HttpStatus.OK);

  @GetMapping("/")
  public Response index() {
    return apiOk;
  }
}
