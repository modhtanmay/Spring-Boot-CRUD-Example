package com.tanmay.spring.CrudOperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanmay.spring.CrudOperations.model.Product;
import com.tanmay.spring.CrudOperations.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listAll(String keyword) {
		if(keyword!=null) {
			return productRepository.search(keyword);
		}
		return productRepository.findAll();
	}
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public Product get(long id) {
		return productRepository.findById(id).get();
	}
	
	public void delete(long id) {
		productRepository.deleteById(id);
	}

}
