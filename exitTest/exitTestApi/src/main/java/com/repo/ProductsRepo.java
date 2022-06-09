package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.Products;

public interface ProductsRepo extends JpaRepository<Products, Integer> {

	
	public List<Products> findByCode(String code);
	public List<Products> findByName(String name);
	public List<Products> findByBrand(String brand);
	public List<Products> findByPriceLessThanEqual(double price);
	
}
