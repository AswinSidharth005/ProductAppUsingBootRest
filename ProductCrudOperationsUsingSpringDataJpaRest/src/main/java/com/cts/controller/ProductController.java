package com.cts.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.cts.model.Product;
import com.cts.service.ProductService;
 
@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {
	@Autowired
	ProductService service;
 
	@GetMapping("/getMsg") // http://localhost:8080/products/getMsg
	public String sayHello() {
		return "am trying to listen but am getting sleep";
	}
 
	@PostMapping("/saveproduct") // http://localhost:8080/products/saveproduct
	public String insertProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
}
 
 