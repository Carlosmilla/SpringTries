package com.spring.xe.servicies;

import java.util.List;
import java.util.Optional;

import com.spring.xe.commands.ProductForm;
import com.spring.xe.domain.Product;

public interface IProductService {

	
	List<Product> listAll();
	Optional<Product> getById(Long id);
	Product saveOrUpdate(Product product);
	void delete(Long id);
	Product saveOrUpdateProductForm(ProductForm productForm);
}
