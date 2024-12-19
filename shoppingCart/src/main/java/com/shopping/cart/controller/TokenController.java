package com.shopping.cart.controller;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.models.dto.user.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class TokenController {
	
	private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);;
	
	@Value("${password.user}")
	private String password;
	
	@Value("${token.secretKey}") 
	private String secretKey;
	
	@PostMapping("user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token=null;
		String name=null;
		if(username.trim().equalsIgnoreCase("jaime") && pwd.trim().equalsIgnoreCase(password))
		{
			token = getJWTToken(username);	
			name=username;
		}		
		User user = new User();
		user.setUser(name);
		user.setToken(token);		
		return user;
		
	}
	
	private String getJWTToken(String username) {
		byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        if (keyBytes.length < 64) {
            throw new IllegalArgumentException("Error password");
        }
		
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("JWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000)) // 10 minutos
                .signWith(SignatureAlgorithm.HS512, keyBytes)
                .compact();

        return "Bearer " + token;
	    }

}
