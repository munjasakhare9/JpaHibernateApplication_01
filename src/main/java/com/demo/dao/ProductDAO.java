package com.demo.dao;

import com.demo.entity.ProductEntity;

public interface ProductDAO {
	ProductEntity save(ProductEntity product);

	ProductEntity loadProductById(Integer productId);

	ProductEntity updateProductById(Integer productId, Double new_Unit_Price);

	void deleteProductById(Integer productId);

	void testEntityState();
}
