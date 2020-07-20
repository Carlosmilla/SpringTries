package com.sbw.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class HomeController {

	@GetMapping("/") 
	public String home() {
		return "redirect:/app/index"; // redirecciona al inicio de la app a app/index
		// return "forward:/app/index" // aplica un request y mantiene parametros sin reiniciar
		// idealmente usar forward
	}
}
