package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

public class CategoryServices {
	private CategoryDAO categoryDAO;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager=entityManager;
		this.request = request;
		this.response = response;
		
		categoryDAO=new CategoryDAO(entityManager);
	}
	
	
	
	public void listCategory(String message) throws ServletException, IOException {
		List<Category>listCategory= categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		if(message!=null) {
		request.setAttribute("message", message);
		}
		String listPage="category_list.jsp";
		RequestDispatcher requestDispatcher= request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}
	
	public void createCategory() throws ServletException, IOException {
		String categoryName=request.getParameter("name");
		Category category =  categoryDAO.findByName(categoryName);
		if(category != null) {
		String message="Could not Create Category  becouse Category Name :"+categoryName +" already exist" ;
		request.setAttribute("message", message);
		RequestDispatcher requestDispatcher= request.getRequestDispatcher("message.jsp");
		requestDispatcher.forward(request, response);
		}else {
			
			Category newCategory = new Category(categoryName);
			categoryDAO.create(newCategory);
			String message="New category create successfully.";
			listCategory(message);
			
		}
	}



	public void editCategory() throws ServletException, IOException {
		int categoryId=Integer.parseInt(request.getParameter("id"));
		Category category=categoryDAO.get(categoryId);
		
		String editPage="category_form.jsp";
		request.setAttribute("category", category);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
		
		
	}



	public void updateCategory() throws ServletException, IOException {
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		String categoryName=request.getParameter("name");
		Category categoryById=categoryDAO.get(categoryId);
		Category categoryByName=categoryDAO.findByName(categoryName);
		if(categoryByName!=null && categoryById.getCategoryId()!=categoryByName.getCategoryId())
		{
			String message="<font color=red>Could not update user with email :"+categoryName+" already exist.</font>";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
//			Category category=new Category(categoryId, categoryName);
//			categoryDAO.update(category);
			categoryById.setName(categoryName);
			categoryDAO.update(categoryById);
			String message="Category has been updated successfully.";
			listCategory(message);
		}
	}



	public void deleteCategory() throws ServletException, IOException {
		int categoryId=Integer.parseInt(request.getParameter("id"));
		categoryDAO.delete(categoryId);
		
		String message="Category with Id "+categoryId+" has been deleted successfully.";
		listCategory(message);

	}

}
