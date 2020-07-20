package com.sbw.web.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.sbw.web.di.models.service.IServicio;
import com.sbw.web.di.models.service.MiServicio;
import com.sbw.web.di.models.service.MiServicioComplejo;

@Configuration
public class appConfig {

	@Bean("miServicio")
	
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	
	@Primary
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
}
