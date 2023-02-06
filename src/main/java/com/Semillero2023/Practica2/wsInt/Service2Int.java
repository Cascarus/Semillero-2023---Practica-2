package com.Semillero2023.Practica2.wsInt;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Semillero2023.Practica2.entity.Usuario;

@CrossOrigin
@RestController
@RequestMapping("/publico")
public interface Service2Int {
	
	@GetMapping("/todosUsuarios")
	public List<Usuario> test2();
	
	@GetMapping("/test")
	public String test();

}
