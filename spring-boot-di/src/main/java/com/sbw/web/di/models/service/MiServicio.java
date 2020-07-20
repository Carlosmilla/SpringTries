package com.sbw.web.di.models.service;

import org.springframework.stereotype.Service;

//@Service("miServicio") // provee datos de logica
public class MiServicio implements IServicio{

	@Override
	public String operacion() {
		// TODO Auto-generated method stub
		return "ejecutando una operacion";
	}

	// en caso de tener una clase con argumentos debe de
	// "" llevar un constructor por defecto vacio
}
