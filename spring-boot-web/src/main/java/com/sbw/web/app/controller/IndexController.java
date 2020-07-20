package com.sbw.web.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.sbw.web.app.models.Usuario;

@Controller
@RequestMapping("/app") // ruta de primer nivel
public class IndexController {
	
	private String textoIndex;
	private String textoPerfil;
	private String textoListar;
	
	// public String index(Map<String, Object> map) {
    // map.put("titulo", "mensaje");
	// return "index"; } --- misma funcion para pasar datos a la vista
		
	// public ModelAndView index(ModelAndView mv) {
	// mv.addObject("titulo", "mensaje");
    // mv.setViewName("index");
	// return "index"; } // misma funcion para pasar datos a la vista
	
	//@RequestMapping(value="/index", method = RequestMethod.GET)
	//@GetMapping({"/index","/","/home"}) se puede mapear a multiples URL
	@GetMapping(value = "/index") // value es parametro por defecto en caso de asignar mas
	public String index(Model model) {  // ModelMap cumple la misma funcion pero con diferencte implementacion
		model.addAttribute("titulo", "Hola SPF");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario(); //instancia de una clase para poder usar sus atributos
		usuario.setNombre("Pepe");
		usuario.setApellido("palos");
		usuario.setEmail("pepe@correo.cl");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "perfil del usuario: ".concat(usuario.getNombre())); // se establece un titulo y se concatena con la instancia de la clase
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		
		//List<Usuario> usuarios = new ArrayList<>();
		//usuarios.add(new Usuario("Pepe", "Palos", "pepe@correo.cl"));
		//usuarios.add(new Usuario("Pepa", "Palas", "pepa@correo.cl"));
		//usuarios.add(new Usuario("Pepo", "Polos", "pepo@correo.cl"));
		
		model.addAttribute("titulo", "Listado de usuarios");
		//model.addAttribute("usuarios", usuarios);
		
	
		return "listar";
	}
	
	@ModelAttribute("usuarios") // idealmente se usa en formularios para poblar selects, radios, checklist
	// o para usarlo en multiples metodos, en caso de vistas aisladas no es necesario
	public List<Usuario> poblarUsuarios() {

		List<Usuario> usuarios = Arrays.asList(new Usuario("Pepe", "Palos", "pepe@correo.cl"),
				new Usuario("Pepa", "Palas", "pepa@correo.cl"), 
				new Usuario("Pepo", "Polos", "pepo@correo.cl"));
		
		return usuarios;
	}
	

}
