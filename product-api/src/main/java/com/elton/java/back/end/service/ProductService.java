package com.elton.java.back.end.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elton.java.back.end.converter.DTOConverter;
import com.elton.java.back.end.exception.CategoryNotFoundException;
import com.elton.java.back.end.exception.ProductNotFoundException;
import com.elton.java.back.end.model.Product;
import com.elton.java.back.end.model.dto.ProductDTO;
import com.elton.java.back.end.repository.CategoryRepository;
import com.elton.java.back.end.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<ProductDTO> getAll() {
		List<Product> products = productRepository.findAll();
		return products
			.stream()
			.map(DTOConverter::convert)
			.collect(Collectors.toList());
	}

	public List<ProductDTO> getProductByCategoryId(Long categoryId) {
		
		List<Product> products = productRepository.getProductByCategory(categoryId);
		return products
				.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());		
	}
	
	
	public ProductDTO findByProductIdentifier(String productIdentifier) {
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		if(product != null) {
			return DTOConverter.convert(product);			
		}
		return null;
	}
	
	public ProductDTO save(ProductDTO productDTO) {
//		Boolean existsCategory = categoryRepository.existsById(productDTO.getCategory().getId());
//		if (!existsCategory) {
//			throw new CategoryNotFoundException();
//		}		
		Product product = productRepository.save(Product.convert(productDTO));
		return ProductDTO.convert(product);
	}
	
	public ProductDTO delete(long ProductId) throws ProductNotFoundException {
		Optional<Product> product = productRepository.findById(ProductId);
		if(product.isPresent()) {
			productRepository.delete(product.get());
		}
		return null;
	}
	
	
}
