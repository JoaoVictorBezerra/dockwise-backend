package com.api.containers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class ContainersApplication {
	public static void main(String[] args) {
		SpringApplication.run(ContainersApplication.class, args);
	}
	@GetMapping("/")
	public ResponseEntity<Object> index() {
		return ResponseEntity.status(HttpStatus.OK).body("API Funcionando");
	}
}
// Senha: jvictor123