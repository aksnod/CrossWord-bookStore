package com.bookstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UserTest {

	public static void main(String[] args) {
	    Users user1=new Users();
		user1.setEmail("kp@.com");
		user1.setFullName("kp");
		
		user1.setPassword("p");
		
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("BookStoreWebsite");
		
		EntityManager	entityManager= entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("AA users object was persistede");
	}

}
