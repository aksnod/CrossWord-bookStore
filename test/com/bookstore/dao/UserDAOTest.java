package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest extends BaseDAOTest {
	
    private static	UserDAO userDAO;
    @BeforeClass
    public static void  setupClass() throws Exception
    {
		BaseDAOTest.setUpBeforeClass();
		userDAO=new UserDAO(entityManager);
    }
	@Test
	public void testCreateUsers() {

	    Users user1=new Users();
		user1.setEmail("ahnnhh123@narayan");
		user1.setFullName("ramfg");
		
		user1.setPassword("asijj34e12");
		
		user1=userDAO.create(user1);
		
	    assertTrue(user1.getUserId()>0);
	}
	
	@Test(expected=PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
	    Users user1=new Users();
		user1=userDAO.create(user1);
	}
	
	@Test
	public void testUpdateUsers()
	{
		Users user=new Users();
		user.setUserId(1);
		user.setEmail("change@gmail.com");
		user.setFullName("change");
		user.setPassword("change");
		
	    user=	userDAO.update(user);
	     String expected="change";
	     String actual=user.getPassword();
	    assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId=1;
		Users user=userDAO.get(userId);
		if(user!=null) {
		System.out.println(user.getEmail());
		}
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId=99;
		Users user=userDAO.get(userId);
		assertNull(user);
		
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId=4;
		userDAO.delete(userId);
		Users user=userDAO.get(userId);
		assertNull(user);
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void testDeleteNotExistUsers() {
		Integer userId=29;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers=userDAO.listAll();
		for(Users user:listUsers)
		{
			System.out.println(user.getEmail());
		}
		assertTrue(listUsers.size()>0 );
	}
	
	@Test
	public void testCount()
	{
		long totalUsers=userDAO.count();
		assertEquals(15	, totalUsers);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email="np@patel";
		String password="n patel";
		boolean loginResult=userDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
		
	}
	
	@Test
	public void testCheckLoginFailed() {
		String email="nppatel";
		String password="npatel";
		boolean loginResult=userDAO.checkLogin(email, password);
		
		assertFalse(loginResult);
		
	}
	
	@Test
	public void testFindByEmail()
	{
		String email="awadh@narayan";
		Users user=userDAO.findByEmail(email);
		assertNotNull(user);
	}
	
	@AfterClass
	public static void tearDownClass()
	{
		entityManager.close();
		entityManagerFactory.close();
	}

}
