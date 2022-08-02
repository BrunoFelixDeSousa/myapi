package com.bruno.myapi;

import com.bruno.myapi.domain.Usuario;
import com.bruno.myapi.repositories.UsuarioRepsoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyapiApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepsoitory usuarioRepsoitory;

	public static void main(String[] args) {
		SpringApplication.run(MyapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Bruno Felix", "Bruno", "123");
		Usuario u2 = new Usuario(null, "Naruto Uzumaki", "Naruto", "123");

		usuarioRepsoitory.saveAll(Arrays.asList(u1, u2));

	}
}
