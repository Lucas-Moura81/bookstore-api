package com.bookstore.bookstore_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore_api.domain.Categoria;
import com.bookstore.bookstore_api.repositories.CategoriaRepository;
import com.bookstore.bookstore_api.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!" + id + ", tipo: " + Categoria.class.getName()));

	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj); 
	}
}
