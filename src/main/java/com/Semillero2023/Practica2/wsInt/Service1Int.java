package com.Semillero2023.Practica2.wsInt;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Semillero2023.Practica2.entity.Usuario;

@CrossOrigin
@RestController
@RequestMapping("/privado")
public interface Service1Int{
	
	@PostMapping("/login")
	public ResponseEntity<?>loginUser(@RequestBody Usuario user);
	
	@GetMapping("/todosUsuarios")
	public List<Usuario> test2();
	
	@GetMapping("/sms")
	public String mensaje();
	
}
