package com.demo.services;

import java.util.List;

import com.demo.entities.Product;

public interface ProductService {

	public List<String> search(String keyword);

	//List<Product> searchDetail(String keyword);

	List<Product> searchFull(String keyword);

}