package com.spring.login.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passgenerator {

	public static void main(String ...args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		//El String que mandamos al metodo encode es el password que se encriptara en este caso 1234
		System.out.println(bCryptPasswordEncoder.encode("2222"));
	}
}
