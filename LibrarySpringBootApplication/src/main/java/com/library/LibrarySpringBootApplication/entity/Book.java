package com.library.LibrarySpringBootApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO_INCREMENT
private int id;
private String title;
private String author;      //public List<Book> findByAuthor(String x);
private String category;
}
