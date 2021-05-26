package com.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookServices {
	private BookDAO bookDAO;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryDAO categoryDAO;
	
	public BookServices(EntityManager entityManager,HttpServletRequest request,HttpServletResponse response) {
		super();
		this.request=request;
		this.response=response;
		this.entityManager=entityManager;
		bookDAO=new BookDAO(entityManager);
		categoryDAO=new CategoryDAO(entityManager);
	}

	public void listBooks() throws ServletException, IOException {
		List<Book> listBook=bookDAO.listAll();
		request.setAttribute("listBook", listBook);
		
		String listPage="books_list.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}

	public  void showNewBookForm() throws ServletException, IOException {
		List<Category> listCategory=categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		
		String newPage="book_form.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(newPage);
		requestDispatcher.forward(request, response);
		
	}

	public void createBook() throws ServletException, IOException {
		int categoryId=Integer.parseInt(request.getParameter("category"));
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String description=request.getParameter("description");
		String isbn=request.getParameter("isbn");
		float price=Float.parseFloat(request.getParameter("price"));
		
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate;
		try {
			publishDate=dateFormat.parse(request.getParameter("publishDate"));
		} catch (ParseException ex) {
			ex.printStackTrace();
			throw new ServletException(" Error publish date format");
		}
		System.out.println(categoryId+"   "+title+"   "+author+"   "+description+"   "+isbn+"   "+price+"   "+publishDate);
		
		Book newBook=new Book();
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setDescription(description);
		newBook.setIsbn(isbn);
		newBook.setPublishDate(publishDate);
		
		Category category=categoryDAO.get(categoryId);
		newBook.setCategory(category);
		newBook.setPrice(price);
		
		Part part=request.getPart("bookImage");
		if(part!=null && part.getSize()>0) {
			long size=part.getSize();
			byte[] imageBytes=new byte[(int) size];
			
			InputStream inputStream=part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			newBook.setImage(imageBytes);
		}
		Book createBook=bookDAO.create(newBook);
		
		if(createBook.getBookId()>0) {
			String message="New book create successfully.";
			request.setAttribute("message", message);
			listBooks();
		}
	}
}
