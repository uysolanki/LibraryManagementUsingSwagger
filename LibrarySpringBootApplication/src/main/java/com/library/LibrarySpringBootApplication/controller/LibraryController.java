package com.library.LibrarySpringBootApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.LibrarySpringBootApplication.entity.Book;
import com.library.LibrarySpringBootApplication.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
public class LibraryController {
	
	@Autowired
	BookService bookservice;
	
	@Value("${spring.application.name}")
	public String appname;
	
	@Value("${info.developer.name}")
	public String developername;
	
	@Value("${info.developer.email}")
	public String developeremail;
	
	@ApiOperation(value = "Application Name", notes = "Name of the Application")
	@GetMapping("/appname")
	public String getAppName()
	{
	return "Application name " +appname;
	}
	
	@GetMapping("/developername")
	public String getDeveloperName()
	{
	return "Application name " +developername;
	}
	
	@GetMapping("/developerEmail")
	public String getDeveloperEmail()
	{
	return "Application name " +developeremail;
	}
	
	
//	private String title;
//	private String author;
//	private String category;
	@ApiOperation(value = "Add Book", notes = "Add Book By Accepeting Parameters from User")
	@PostMapping("/addBookByRequestParam")
	public Book addBookByRequestParam(@RequestParam("titlefront") String titlejava,@RequestParam("authorfront") String authorjava,@RequestParam("categoryfront") String categoryjava)
	{
		Book b1=new Book();
		b1.setAuthor(authorjava);
		b1.setTitle(titlejava);
		b1.setCategory(categoryjava);
		return bookservice.addBook(b1);
	}
	
	@ApiOperation(value = "Add Book", notes = "Add Book By Path Variables")
	@PostMapping("/addBookByPathVariables/{titlefront}/{authorfront}/{categoryfront}")
	public Book addBookByPathVariables(@PathVariable("titlefront") String titlejava,@PathVariable("authorfront") String authorjava,@PathVariable("categoryfront") String categoryjava)
	{
		Book b1=new Book();
		b1.setAuthor(authorjava);
		b1.setTitle(titlejava);
		b1.setCategory(categoryjava);
		return bookservice.addBook(b1);
	}
	
	@ApiOperation(value = "Add Book", notes = "Add Book By Accepeting Object from User")
	@PostMapping("/addBookByRequestBody")
	public Book addBookByRequestBody(@RequestBody Book b2)
	{
		return bookservice.addBook(b2);
	}
	
	
	@GetMapping("/getBookDetailsById")
	public Book getBookDetailsById(@RequestParam("bookid") int id)
	{
		return bookservice.getBookById(id);
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks()
	{
		return bookservice.getAllBooks();
	}
	
	@GetMapping("/getBookDetailsByAuthorName")
	public List<Book> getBookDetailsByAuthorName(@RequestParam("authorname") String authorname)
	{
		return bookservice.getBookByAuthorName(authorname);
	}
	
	@GetMapping("/getBookDetailsByAuthorNameAndCategory")
	public List<Book> getBookDetailsByAuthorNameAndCategory(@RequestParam("authorname") String authorname,@RequestParam("categoryrname") String categoryrname)
	{
		return bookservice.getBookDetailsByAuthorNameAndCategory(authorname,categoryrname);
	}
	
	@GetMapping("/getBookOrderByTitle")
	public List<Book> getBookOrderByTitle()
	{
		return bookservice.getBookOrderByTitle();
	}
	
	@DeleteMapping("/deleteBookById")
	public String deleteBookById(@RequestParam("bookid") int id)
	{
		bookservice.deleteBookById(id);
		return "Book Deleted";
	}
	
	@DeleteMapping("/deleteBookByCategory")
	public String deleteBookByCategory(@RequestParam("categoryrname") String categoryrname)
	{
		bookservice.deleteBookByCategory(categoryrname);
		return "Book Deleted";
	}

}
