package com.shopping.cart.implement.product;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shopping.cart.interfaces.product.ProductsInterfaces;
import com.shopping.cart.models.dto.product.Product;
import com.shopping.cart.utilidades.Constantes;

@Service
public class ProductsService implements ProductsInterfaces{

	private final RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public ResponseEntity<Object> getProduct(Long id) {
		ResponseEntity<Object> responseEntity = null;
		String url = Constantes.URL_PRODUCTS+"/"+id;
		responseEntity  = restTemplate.getForEntity(url, Object.class); 		
		return responseEntity;
	}

	@Override
	public ResponseEntity<Object> allProducts() {
		
		ResponseEntity<Object> responseEntity = null;
		String url = Constantes.URL_PRODUCTS;
		responseEntity  = restTemplate.getForEntity(url, Object.class); 		
		return responseEntity;
	}
	
	@Override
	public ResponseEntity<Object> limitResult(Long id) {
		
		ResponseEntity<Object> responseEntity = null;
		String url = Constantes.URL_PRODUCTS+"?limit="+id;
		responseEntity  = restTemplate.getForEntity(url, Object.class); 		
		return responseEntity;
	}
	
	@Override
	public ResponseEntity<Object> sortResults(String value) {
		
		ResponseEntity<Object> responseEntity = null;
		String url = Constantes.URL_PRODUCTS+"?sort="+value;
		responseEntity  = restTemplate.getForEntity(url, Object.class); 		
		return responseEntity;
	}
	
	@Override
	public ResponseEntity<Object> getAllCategories() {
		
		ResponseEntity<Object> responseEntity = null;
		String url = Constantes.URL_PRODUCTS+"/categories";
		responseEntity  = restTemplate.getForEntity(url, Object.class); 		
		return responseEntity;
	}
	
	@Override
	public ResponseEntity<Object> getProductsSpecificCategory(String value) {
		
		ResponseEntity<Object> responseEntity = null;
		String url = Constantes.URL_PRODUCTS+"/category/"+value;
		responseEntity  = restTemplate.getForEntity(url, Object.class); 		
		return responseEntity;
	}

	@Override
	public ResponseEntity<Object> addNewProduct(Product product) {
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = Constantes.URL_PRODUCTS;
		HttpEntity<Product> requestEntity = new HttpEntity<>(product, headers); 
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class); 
		return response;		
	}	
	
	@Override
	public ResponseEntity<Object> updateProduct(Product product) {
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = Constantes.URL_PRODUCTS+"/"+product.getProductId();
		HttpEntity<Product> requestEntity = new HttpEntity<>(product, headers); 
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Object.class); 
		return response;		
	}
	
	@Override
	public ResponseEntity<Object> deleteProduct(Long id) {		
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = Constantes.URL_PRODUCTS+"/"+id;
		HttpEntity<Product> requestEntity = new HttpEntity<>(headers); 
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Object.class); 
		return response;
	}

}
