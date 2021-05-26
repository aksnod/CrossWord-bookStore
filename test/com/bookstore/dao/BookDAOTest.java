package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest extends BaseDAOTest{
	private static BookDAO bookDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		bookDao=new BookDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testCreateBook() throws IOException, ParseException {
		Book newBook=new Book();
		
		Category category=new Category("HTML");
		category.setCategoryId(40);
		newBook.setCategory(category);
		
		newBook.setTitle("HTML  Advanced");
		newBook.setAuthor("West");
		newBook.setDescription("  Foundations will give you the knowledge to move beyond the constraints of prebuilt themes and simple site building tools. It will empower hobbyists, freelancers and entrepreneurs, to create fully customized websites that match their needs perfectly.");
	    newBook.setPrice(34.5f);
	    newBook.setIsbn("1234565434");
	    
	    DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
	    
	    Date publishDate=dateFormat.parse("04/11/2013");
	    newBook.setPublishDate(publishDate);
	    
	   String imagePath="E:\\EclipseJava\\BookProject\\DummyData\\books\\HTML 5 Foundations.JPG";
		byte[] imageBytes=Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
	    
	    
	    newBook=bookDao.create(newBook);
	    
	    assertTrue(newBook!=null );
	}
 
	@Test
	public void testUpdateBook() throws IOException, ParseException {
		Book existBook=new Book();
		
		Category category=new Category("PHP");
		category.setCategoryId(39);
		existBook.setCategory(category);
		existBook.setBookId(1);
		existBook.setTitle("PHP  Advanced");
		existBook.setAuthor("P.h.J");
		existBook.setDescription("  Foundations will give you the knowledge to move beyond the constraints of prebuilt themes and simple site building tools. It will empower hobbyists, freelancers and entrepreneurs, to create fully customized websites that match their needs perfectly.");
	    existBook.setPrice(54.5f);
	    existBook.setIsbn("1244565434");
	    
	    DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
	    
	    Date publishDate=dateFormat.parse("04/11/2013");
	    existBook.setPublishDate(publishDate);
	    
	   String imagePath="E:\\EclipseJava\\BookProject\\DummyData\\books\\HTML 5 Foundations.JPG";
		byte[] imageBytes=Files.readAllBytes(Paths.get(imagePath));
		existBook.setImage(imageBytes);
	    
	    
	    Book updateBook=bookDao.update(existBook);
	    assertEquals(updateBook.getTitle(),"PHP  Advanced");
	    
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void testDeleteBookFail() {
		Integer bookId=100;
		bookDao.delete(bookId);
		
	}
	
	@Test
	public void testDeleteBookSuccess() {
		Integer bookId=1;
		bookDao.delete(bookId);
		
		assertTrue(true);
	}
	
	@Test
	public void testGetBookFail() {
		Integer bookId=99;
		Book book =bookDao.get(bookId);
		assertNull(book);
	}
	
	@Test
	public void testGetBookSuccess() {
		Integer bookId=4;
		Book book =bookDao.get(bookId);
		assertNotNull(book);
	}
	
	@Test
	public void testListAll(){
		List<Book> listBook=bookDao.listAll();
		
		assertFalse(listBook.isEmpty());
	}
	
	@Test
	public void testFindByTitleNotExist() {
		String title="ndjnfjnfjk";
		Book book=bookDao.findByTitle(title);
		assertNull(book);
	}
	
	@Test
	public void testFindByTitleExist() {
		String title="HTML  Basic";
		Book book=bookDao.findByTitle(title);
		assertNotNull(book);
	}
	
	@Test
	public void testCount() {
		long totalBooks=bookDao.count();
		assertEquals(2	, totalBooks);
	}
}
