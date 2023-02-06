package com.Semillero2023.Practica2.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.Semillero2023.Practica2.config.JwtGeneratorInterface;
import com.Semillero2023.Practica2.entity.Usuario;
import com.Semillero2023.Practica2.repository.UsuarioRepository;
import com.Semillero2023.Practica2.wsInt.Service1Int;

@Component
public class Service1 implements Service1Int {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	JwtGeneratorInterface jwtGenerator;

	@Override
	public ResponseEntity<?> loginUser(Usuario user) {

		try {
			if (user.getUsername() == null || user.getPassword() == null) {
				return new ResponseEntity<>("UserName or Password is Empty", HttpStatus.NOT_ACCEPTABLE);
			}
			Usuario userData = usuarioRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			if (userData == null) {
				return new ResponseEntity<>("UserName or Password is Invalid", HttpStatus.NOT_ACCEPTABLE);
			}
			return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@Override
	public List<Usuario> test2() {
		return usuarioRepository.findAll();
	}

	@Override
	public String mensaje() {
		// TODO Auto-generated method stub
		return "Este es un mensaje desde el endpoint restringido";
	}

}
