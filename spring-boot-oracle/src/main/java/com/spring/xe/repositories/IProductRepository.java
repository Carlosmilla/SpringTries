package com.spring.xe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.xe.domain.Product;

public interface IProductRepository extends CrudRepository<Product, Long> {

}

// al declarar la interface del repositorio spring proveera una instancia para la clae
