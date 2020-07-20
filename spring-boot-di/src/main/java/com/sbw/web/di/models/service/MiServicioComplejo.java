package com.sbw.web.di.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("miServicioComplejo")// porvee datos de logica
//@Primary // se define como bean primario 
public class MiServicioComplejo implements IServicio{

	@Override
	public String operacion() {
		// TODO Auto-generated method stub
		return "ejecutando una operacion complicada";
	}

	// en caso de tener una clase con argumentos debe de
	// "" llevar un constructor por defecto vacio
}
