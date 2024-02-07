package com.elton.java.back.end.converter;

import com.elton.java.back.end.model.Category;
import com.elton.java.back.end.model.Product;
import com.elton.java.back.end.model.dto.CategoryDTO;
import com.elton.java.back.end.model.dto.ProductDTO;

public class DTOConverter {
	
	public static CategoryDTO convert(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setNome(category.getNome());
		return categoryDTO;
	}
	
	
	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		if (product.getCategory() != null) {
			productDTO.setCategory(DTOConverter.convert(product.getCategory()));
		}
		return productDTO;
	}	
}
