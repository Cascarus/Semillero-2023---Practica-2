package com.Semillero2023.Practica2.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Semillero2023.Practica2.entity.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface {

	@Value("${jwt.secret}")
	private String secret;

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	@Override
	public Map<String, String> generateToken(Usuario user) {
		String jwtToken = "";
		jwtToken = Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + (1000*60)))
				.signWith(SignatureAlgorithm.HS256, "secret")
				.compact();
		Map<String, String> jwtTokenGen = new HashMap<>();
		jwtTokenGen.put("token", jwtToken);
		return jwtTokenGen;
	}
	

}
