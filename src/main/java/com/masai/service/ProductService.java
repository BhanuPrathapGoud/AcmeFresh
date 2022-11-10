package com.masai.service;

import java.util.List;

import com.masai.exception.ProductNotFound;
import com.masai.model.Products;

public interface ProductService {
	public List<Products> getAllProductsList()throws ProductNotFound;
	public Products getProductsById(int Id)throws ProductNotFound;
	public String createProducts(Products Products) throws ProductNotFound;
	public Products deleteProductsById(int id)throws ProductNotFound;
	public Products updateProductsById(int id, Products Products)throws ProductNotFound;
}
