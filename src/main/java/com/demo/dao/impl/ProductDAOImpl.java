package com.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.demo.dao.ProductDAO;
import com.demo.entity.ProductEntity;

public class ProductDAOImpl implements ProductDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

	@Override
	public ProductEntity save(ProductEntity product) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		try {
			entityManager.persist(product);
			tx.commit();
			System.out.println("product inserted to the Database...");
		} catch (Exception ex) {
			tx.rollback();
			System.out.println("Error in inserting a product..." + ex);
		} finally {
			entityManager.close();
		}
		return product;
	}

	@Override
	public ProductEntity loadProductById(Integer productId) {
		EntityManager entityManager = factory.createEntityManager();
		/*
		 * find() : early load getReference() : lazy load
		 */
		ProductEntity product = entityManager.find(ProductEntity.class, productId);
		entityManager.close();
		return product;
	}

	@Override
	public ProductEntity updateProductById(Integer productId, Double new_Unit_Price) {
		EntityManager entityManager = factory.createEntityManager();
		ProductEntity product = entityManager.find(ProductEntity.class, productId);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		product.setUnitPrice(new_Unit_Price);
		tx.commit();
		entityManager.close();
		return product;
	}

	@Override
	public void deleteProductById(Integer productId) {
		EntityManager entityManager = factory.createEntityManager();
		ProductEntity product = entityManager.find(ProductEntity.class, productId);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(product);
		tx.commit();
		entityManager.close();
	}

	public void testEntityState() {
		EntityManager entityManager = factory.createEntityManager();
		// create new product
		/*
		 * ProductEntity pe = new ProductEntity(); // Transient State
		 * 
		 * pe.setProduct_id(27620); pe.setProductName("Earburds"); pe.setQuantity(5);
		 * pe.setUnitPrice(2400.0); EntityTransaction tx =
		 * entityManager.getTransaction(); tx.begin(); entityManager.persist(pe); //
		 * Persistent State tx.commit();
		 */
		ProductEntity pe = entityManager.find(ProductEntity.class, 27620);
		entityManager.detach(pe); // Detached State
		pe.setUnitPrice(3100.0); // changes made to an entity in detached state does not effect

		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.merge(pe); // moved from detached state to persistent state
		t.commit();
		entityManager.close();
	}

}
