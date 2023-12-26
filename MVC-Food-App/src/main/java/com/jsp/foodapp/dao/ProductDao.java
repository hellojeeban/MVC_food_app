package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.Product;

@Repository
public class ProductDao {
	@Autowired
	EntityManagerFactory emf;

	public void saveProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();
	}
	public List<Product> fetchAllProduct(){
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p");
		return query.getResultList();
	}
	
	public Product findProductById(int id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Product p = em.find(Product.class, id);
		et.commit();
		return p;
	}
	public void updateProduct(Product p){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(p);
		et.commit();
	}
	public void deleteProduct(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Product p = em.find(Product.class, id);
		em.remove(p);
		et.commit();
	}
	
}
