package com.jsp.foodapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.User;

@Repository
public class UserDao {
	@Autowired
	EntityManagerFactory emf;

	public void saveUser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(u);
		et.commit();
	}

	public User findUser(String email, String password) {
		EntityManager em = emf.createEntityManager();
		String q = "Select u from User u where u.email=?1 and u.password=?2";
		Query query = em.createQuery(q);
		query.setParameter(1, email);
		query.setParameter(2, password);
		User user = (User) query.getSingleResult();
		try {
			return user;
		} catch (Exception e) {
			return null;
		}
	}
	public void updateUser(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(u);
		et.commit();
	}
}
