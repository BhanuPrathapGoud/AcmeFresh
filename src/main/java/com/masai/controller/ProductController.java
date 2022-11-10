package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ProductNotFound;
import com.masai.model.Products;
import com.masai.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	@PostMapping("/Products")
	public ResponseEntity<String>   createProducts(@RequestBody Products Products) throws ProductNotFound {
		String status =  productService.createProducts(Products);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	@GetMapping("/Products")
	public ResponseEntity<List<Products>> getAllProductsList() throws ProductNotFound{
		return new ResponseEntity<>(productService.getAllProductsList(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/Products/{id}")
	public ResponseEntity<Products> getProductsById(@PathVariable int id) throws ProductNotFound {
		return new ResponseEntity<Products>(productService.getProductsById(id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/Products/{id}")
	public ResponseEntity<Products> deleteProductsById(@PathVariable int id) throws ProductNotFound {
		return new ResponseEntity<Products>(productService.deleteProductsById(id),HttpStatus.ACCEPTED);
	}
	@PatchMapping("/Products/{id}")
	public ResponseEntity<Products> updateProductsById(@PathVariable int id,@RequestBody Products Products) throws ProductNotFound {
		return new ResponseEntity<Products>(productService.updateProductsById(id,Products),HttpStatus.CREATED);
	}
}
