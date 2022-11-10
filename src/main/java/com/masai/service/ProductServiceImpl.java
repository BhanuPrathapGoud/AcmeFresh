package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductNotFound;
import com.masai.model.Products;
import com.masai.repository.ProductDao;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;

	@Override
	public List<Products> getAllProductsList() throws ProductNotFound{
		List<Products> list = productDao.findAll();
		if(list.size() > 0) {
			return list;
		}else {
			throw new  ProductNotFound("Productss not exist");
		}
	}

	@Override
	public Products getProductsById(int id) throws ProductNotFound{
		Optional<Products> opt = productDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new  ProductNotFound("Products no exist with this"+id);
		}
	}

	@Override
	public String createProducts(Products Products) throws ProductNotFound {
		Optional<Products> opt = productDao.findById(Products.getProductid());
		if(opt.isPresent()) {
			throw new ProductNotFound("This Productss Already Created");
		}else {
			productDao.save(Products);
			return "Productss Created Sucessfully";
		}
	}

	@Override
	public Products deleteProductsById(int id) throws ProductNotFound {
		Optional<Products> opt = productDao.findById(id);
		if(!opt.isPresent()) {
			throw new  ProductNotFound("Products no exist with this"+id);
		}else {
			Products Productss = opt.get();
			productDao.delete(opt.get());
			return Productss;
		}
	}

	@Override
	public Products updateProductsById(int id,Products Products) throws ProductNotFound {
		Optional<Products> opt = productDao.findById(id);
		if(!opt.isPresent()) {
			throw new  ProductNotFound("Products no exist with this"+id);
		}else {
			productDao.save(Products);			
			return Products;
		}
	}
}
