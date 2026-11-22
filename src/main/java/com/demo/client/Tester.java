package com.demo.client;

import com.demo.dao.ProductDAO;
import com.demo.dao.impl.ProductDAOImpl;

public class Tester {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAOImpl();
		/*
		 * create a new product entity
		 * 
		 * ProductEntity pEntity = new ProductEntity(); pEntity.setProduct_id(129015);
		 * pEntity.setProductName("KEYBOARD"); pEntity.setQuantity(18);
		 * pEntity.setUnitPrice(1500.0);
		 * 
		 * 
		 * call saveProduct() of DAO class dao.save(pEntity);
		 */

		/*
		 * call updateProductById() of DAO class ProductEntity p =
		 * dao.updateProductById(129015, 2000.0); System.out.println(p);
		 *
		 */

//		  ProductEntity p = dao.updateProductById(129011, 45000.0);
//		  System.out.println(p);

		/*
		 * call deleteProductById() of DAO class dao.deleteProductById(129015);
		 */

		dao.testEntityState();

	}
}
