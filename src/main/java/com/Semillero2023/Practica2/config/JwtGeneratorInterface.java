package com.Semillero2023.Practica2.config;

import java.util.Map;

import com.Semillero2023.Practica2.entity.Usuario;

public interface JwtGeneratorInterface {
	Map<String, String> generateToken(Usuario user);
}
