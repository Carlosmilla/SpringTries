package com.sbw.web.di.models.service;


public interface IServicio {

	public String operacion();
}

/* @Component Preferable for component scanning and automatic wiring.

When should you use @Bean?

Sometimes automatic configuration is not an option. When? Let's imagine that you want to wire components
from 3rd-party libraries (you don't have the source code so you can't annotate its classes with @Component),
so automatic configuration is not possible.

The @Bean annotation returns an object that spring should register as bean in application context.
The body of the method bears the logic responsible for creating the instance.*/