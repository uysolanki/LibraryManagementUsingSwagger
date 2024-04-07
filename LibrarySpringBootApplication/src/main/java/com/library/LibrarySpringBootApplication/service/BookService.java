package com.library.LibrarySpringBootApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.LibrarySpringBootApplication.entity.Book;
import com.library.LibrarySpringBootApplication.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookrepo;

	public Book addBook(Book b1) {
		return bookrepo.save(b1);
		
	}

	public Book getBookById(int id) {
//		Optional<Book> mybook=bookrepo.findById(id);
//		return mybook.get();
		
		return bookrepo.findById(id).get();
	}

	
	public List<Book> getBookByAuthorName(String authorname) {
		return bookrepo.findByAuthor(authorname);
	}

	public List<Book> getAllBooks() {
		return bookrepo.findAll();
	}

	public List<Book> getBookDetailsByAuthorNameAndCategory(String authorname, String categoryrname) {
		return bookrepo.findByAuthorAndCategory(authorname, categoryrname);
	}

	public List<Book> getBookOrderByTitle() {
		// TODO Auto-generated method stub
		return bookrepo.findBookByOrder();
	}

	public void deleteBookById(int id) {
		bookrepo.deleteById(id);
	}

	public void deleteBookByCategory(String categoryrname) {
		bookrepo.deleteByCategory(categoryrname);
		
	}
	
	
}
