package com.spring.xe.controller;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.xe.commands.ProductForm;
import com.spring.xe.converters.ProductToProductForm;
import com.spring.xe.domain.Product;
import com.spring.xe.servicies.IProductService;


@Controller
public class ProductController {

	private IProductService productService;
	private ProductToProductForm productToProductForm;
	
	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	@Autowired
	public void setProductToProdcutForm(ProductToProductForm productToProdcutForm) {
		this.productToProductForm = productToProdcutForm;
	}
	
	@RequestMapping("/")
	public String redirToList() {
		return "redirect:/product/list";
	}
	@RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.getById(Long.valueOf(id)));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Optional<Product> product = productService.getById(Long.valueOf(id));
        ProductForm productForm = productToProductForm.convert(product);
        model.addAttribute("productForm", productForm);
        return "product/productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "product/productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Validated ProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        Product savedProduct = productService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(Long.valueOf(id));
        return "redirect:/product/list";
    }
	
}
