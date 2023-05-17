package com.bookstore.bookstore_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore_api.domain.Livro;
import com.bookstore.bookstore_api.repositories.LivroRepository;
import com.bookstore.bookstore_api.service.exception.ObjectNotFoundException;

@Service
public class LivroService {
	@Autowired
	LivroRepository repository;  
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException
				("Objeto não encontrado!" + id + ", tipo: " + Livro.class.getName()));
	}

}
