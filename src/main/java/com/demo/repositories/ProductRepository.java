package com.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("SELECT name FROM Product where name like %:keyword%")
	public List<String> search(@Param("keyword") String keyword);
	
	
	@Query("FROM Product where name like %:keyword%")
	public List<Product> searchFull(@Param("keyword") String keyword);


	//public List<Product> searchDetail(String keyword);

}