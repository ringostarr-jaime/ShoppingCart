package com.shopping.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.implement.product.ProductsService;
import com.shopping.cart.models.dto.product.Product;
import com.shopping.cart.models.dto.product.ProductId;
import com.shopping.cart.models.dto.product.ProductValue;
import com.shopping.cart.utilidades.ErrorExceptionHandler;

import jakarta.validation.Valid;


@RestController
@RequestMapping("${products.version}")
public class ProductsController extends ErrorExceptionHandler {
	
	@Autowired
	private ProductsService apiService;

	
	@PostMapping("/singleProduct")
	public ResponseEntity<Object> getProduct(@Valid @RequestBody ProductId product) 
	{ 
		return apiService.getProduct(product.getProductId());
	}
	
	@GetMapping("/allProducts")
	public ResponseEntity<Object> allProducts() 
	{ 
		return apiService.allProducts();
	}
	
	@PostMapping("/limitResult")
	public ResponseEntity<Object> limitResult(@Valid @RequestBody ProductId product) 
	{ 
		return apiService.limitResult(product.getProductId());
	}
	
	@PostMapping("/sortResults")
	public ResponseEntity<Object> sortResults(@Valid @RequestBody ProductValue product) 
	{ 
		return apiService.sortResults(product.getValue());
	}
	
	@GetMapping("/getAllCategories")
	public ResponseEntity<Object> getAllCategories() 
	{ 
		return apiService.getAllCategories();
	}
	
	@PostMapping("/getProductsSpecificCategory")
	public ResponseEntity<Object> getProductsSpecificCategory(@Valid @RequestBody ProductValue product) 
	{ 
		return apiService.getProductsSpecificCategory(product.getValue());
	}
	
	@PostMapping("/addNewProduct")
	public ResponseEntity<Object> addNewProduct(@RequestBody Product product) 
	{ 
		return apiService.addNewProduct(product);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product) 
	{ 
		return apiService.updateProduct(product);
	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<Object> deleteProduct(@Valid @RequestBody ProductId product)  
	{ 
		return apiService.deleteProduct(product.getProductId());
	}
	
}
