package com.proyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyect.entity.Usuario;
import com.proyect.repository.UsuarioRepository;

@Controller
@RequestMapping
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "index";
	}
}
