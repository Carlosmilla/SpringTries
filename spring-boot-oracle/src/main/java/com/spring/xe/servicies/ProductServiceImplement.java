package com.spring.xe.servicies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.xe.commands.ProductForm;
import com.spring.xe.converters.ProductFormToProduct;
import com.spring.xe.domain.Product;
import com.spring.xe.repositories.IProductRepository;

@Service
public class ProductServiceImplement implements IProductService{

	private IProductRepository productRepository;
	private ProductFormToProduct productFormToProduct;
	
	
	
	public ProductServiceImplement(IProductRepository productRepository, ProductFormToProduct productFormToProduct) {
		this.productRepository = productRepository;
		this.productFormToProduct = productFormToProduct;
	}
	

	@Override
	public List<Product> listAll() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Optional<Product> getById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product saveOrUpdate(Product product) {
		productRepository.save(product);
		return product;
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product saveOrUpdateProductForm(ProductForm productForm) {
		Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));
		System.out.println("Producto guardado, id: "+savedProduct.getId());
		return savedProduct;
	}

}
