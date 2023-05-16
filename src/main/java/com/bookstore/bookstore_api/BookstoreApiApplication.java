package com.bookstore.bookstore_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.bookstore_api.repositories.CategoriaRepository;
import com.bookstore.bookstore_api.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApiApplication {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LivroRepository livroRepository; 
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApiApplication.class, args);
	}


}
