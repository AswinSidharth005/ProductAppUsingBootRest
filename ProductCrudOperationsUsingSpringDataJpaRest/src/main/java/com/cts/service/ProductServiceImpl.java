package com.cts.service;
 
import java.util.List;
import java.util.Optional;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.ProductCrudOperationsUsingSpringJpaApplication;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;
 
@Service("productService")
public class ProductServiceImpl implements ProductService {
 
	private final ProductCrudOperationsUsingSpringJpaApplication productCrudOperationsUsingSpringJpaApplication;
 
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
 
	@Autowired
	ProductRepository repository;
 
	ProductServiceImpl(ProductCrudOperationsUsingSpringJpaApplication productCrudOperationsUsingSpringJpaApplication) {
		this.productCrudOperationsUsingSpringJpaApplication = productCrudOperationsUsingSpringJpaApplication;
	}
 
	@Override
	public String saveProduct(Product product) {
		log.info("In ProductServiceImpl saveProduct method"); // warn,error,fatal,info
		Product prod = repository.save(product);
		if (prod != null)
			return "Product Saved Successfully";
		else
			return "something went wrong";
	}
 
	@Override
	public Product updateProduct(Product product) {
		Product prod = repository.save(product);
		return prod;
	}
 
	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);
		return "Product Deleted";
	}
 
	@Override
	public Product getProduct(int productId) {
		Optional<Product> optional = repository.findById(productId);
		return optional.get();
	}
 
	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
 
	@Override
	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice) {
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}
 
	@Override
	public List<Product> getAllProductsByCategory(String category) {
		return repository.findByProductCategory(category);
	}
 
	@Override
	public List<Product> getAllProductsGreaterThan(int productPrice) {
		return repository.findByProductPriceGreaterThan(productPrice);
	}
 
}
 
 