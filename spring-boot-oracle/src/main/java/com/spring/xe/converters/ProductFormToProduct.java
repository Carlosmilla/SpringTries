package com.spring.xe.converters;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.spring.xe.commands.ProductForm;
import com.spring.xe.domain.Product;

@Component
public class ProductFormToProduct implements Converter<ProductForm, Product>{

	@SuppressWarnings("deprecation")
	@Override
	public Product convert(ProductForm productForm) {
		Product product = new Product();
		if(productForm.getId() != null && !StringUtils.isEmpty(productForm.getId())) {
			product.setId(new Long(productForm.getId()));
		}
		product.setDescription(productForm.getDescription());
		product.setPrice(productForm.getPrice());
		product.setImageUrl(productForm.getImageUrl());
		return product;
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
