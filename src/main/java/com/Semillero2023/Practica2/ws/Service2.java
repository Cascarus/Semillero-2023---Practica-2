package com.Semillero2023.Practica2.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Semillero2023.Practica2.config.JwtGeneratorInterface;
import com.Semillero2023.Practica2.entity.Usuario;
import com.Semillero2023.Practica2.repository.UsuarioRepository;
import com.Semillero2023.Practica2.wsInt.Service2Int;

@Component
public class Service2 implements Service2Int{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	JwtGeneratorInterface jwtGenerator;
	
	@Override
	public String test() {
		return "la prueba ha funcionado";
	}
	
	@Override
	public List<Usuario> test2() {
		return usuarioRepository.findAll();
	}
}
