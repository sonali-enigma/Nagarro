package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.entity.Products;
import com.repo.ProductsRepo;


@RestController
@CrossOrigin
public class productsController {

	@Autowired
	ProductsRepo repo;
	
	
	@GetMapping(path="/products")
	public List<Products> getProducts()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/products/id/{id}")
	public Optional<Products> getID(@PathVariable("id") int id)
	{
		return repo.findById(id);

	}
	
	@RequestMapping("/products/code/{code}")
	public List<Products> getCode(@PathVariable("code") String code)
	{
		return repo.findByCode(code);

	}
	
	@RequestMapping("/products/name/{name}")
	public List<Products> getName(@PathVariable("name") String name)
	{
		return repo.findByName(name);

	}
	
	@RequestMapping("/products/brand/{brand}")
	public List<Products> getBrand(@PathVariable("brand") String brand)
	{
		return repo.findByBrand(brand);

	}
	
	@RequestMapping("/products/price/{price}")
	public List<Products> getPrice(@PathVariable("price") double price)
	{
		return repo.findByPriceLessThanEqual(price);

	}
	
}
