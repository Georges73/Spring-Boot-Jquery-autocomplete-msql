package com.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Product;
import com.demo.repositories.ProductRepository;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<String> search(String keyword) {
		return productRepository.search(keyword);
	}
	
	/*
	 * @Override public List<Product> searchDetail(String keyword) { return
	 * productRepository.searchDetail(keyword); }
	 */
	
	@Override
	public List<Product> searchFull(String keyword) {
		List<Product> result = null;
		
		return productRepository.searchFull(keyword);
	}


}