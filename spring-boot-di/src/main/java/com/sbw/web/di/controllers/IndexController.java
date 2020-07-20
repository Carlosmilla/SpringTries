package com.sbw.web.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sbw.web.di.models.service.IServicio;
import com.sbw.web.di.models.service.MiServicio;

@Controller
public class IndexController {

	//private MiServicio servicio = new MiServicio(); // instancia
	
	@Autowired
	//@Qualifier("miServicio") // inyecta mediante el calificador ignorando el primary incluido beans desde appConfig
	private IServicio servicio;
	
	/*public void setServicio(IServicio servicio) {
	this.servicio = servicio;
    } */
	
	/*@Autowired // de forma implicita se inyecta aun sin autowired
	public IndexController(IServicio servicio) {
		this.servicio = servicio;
	}*/


	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion()); // uso de metodo de la instancia
		return "index";
	}
	
	
	
}
