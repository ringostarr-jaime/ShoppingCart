package com.shopping.cart.interfaces.product;

import org.springframework.http.ResponseEntity;

import com.shopping.cart.models.dto.product.Product;



public interface ProductsInterfaces {
	
	ResponseEntity<Object> getProduct (Long id);	
	ResponseEntity<Object> allProducts();
	ResponseEntity<Object> limitResult (Long id);
	ResponseEntity<Object> sortResults (String value);
	ResponseEntity<Object> getAllCategories ();
	ResponseEntity<Object> getProductsSpecificCategory (String value);
	ResponseEntity<Object> addNewProduct (Product value);
	ResponseEntity<Object> updateProduct (Product value);
	ResponseEntity<Object> deleteProduct (Long id);
	
}
