package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class UserServices {
	private UserDAO userDAO;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public UserServices(EntityManager entityManager,HttpServletRequest request,HttpServletResponse response) {
		this.request=request;
		this.response=response;
		this.entityManager=entityManager;
		userDAO=new UserDAO(entityManager);
	}
	
	public void listUser() throws ServletException, IOException {
		
			listUser(null);
		}
		
	public void listUser(String message) throws ServletException, IOException {
		List<Users> listUsers=userDAO.listAll();
		request.setAttribute("listUsers", listUsers);
		if(message!=null) {
		request.setAttribute("message", message);}
		
		String listPage="user_list.jsp";
		RequestDispatcher requestDispatcher= request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void createUser() throws ServletException, IOException
	{
		String email=request.getParameter("email");
		String fullName=request.getParameter("fullname");
		String password=request.getParameter("password");
		
		Users existUser=userDAO.findByEmail(email);
		if(existUser!=null)
		{
			String message="<font color=red>Could not create user. A user already exist with email: </font>  "+email;
			request.setAttribute("message", message);
			RequestDispatcher dispatcher =request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}
		else {
		Users newUser=new Users(email,fullName,password);
		userDAO.create(newUser);
		listUser("New user Create Successfully.");

		}
	}

	public void	 editUser() throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("id"));
		Users user=userDAO.get(userId);
		
		String editPage="user_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
		
	}

	public void updateUser() throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("userId"));
		String email=request.getParameter("email");
		String fullName=request.getParameter("fullname");
		String password=request.getParameter("password");
		
		Users userById=userDAO.get(userId);
		
		Users userByEmail=userDAO.findByEmail(email);
		
		if(userByEmail !=null && userByEmail.getUserId()!=userById.getUserId())
		{
			String message="<font color=red>Could not update user with email :"+email+" already exist.</font>";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			Users user=new Users(userId,email, password, fullName);
			userDAO.update(user);
			
			String message="User has been updated successfully.";
			listUser(message);
		}
	}

	public void deleteUser() throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("id"));
		userDAO.delete(userId);
		
		String message="User has been deleted successfully.";
		listUser(message);
				
	}
	
	public void login() throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		boolean loginResult=userDAO.checkLogin(email, password);
		
		if(loginResult)
		{
			request.getSession().setAttribute("useremail", email);
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/admin/");
			requestDispatcher.forward(request, response);
		}
		else
		{
			String message="Login Failed";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}
	
}
