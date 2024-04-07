package com.library.LibrarySpringBootApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.LibrarySpringBootApplication.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	public List<Book> findByAuthor(String x);
	public List<Book> findByAuthorAndCategory(String x,String y);
	public void deleteByCategory(String x);
	
	@Query(nativeQuery = true, value = "SELECT * FROM book ORDER BY title")
	List<Book> findBookByOrder();
	
	
}
