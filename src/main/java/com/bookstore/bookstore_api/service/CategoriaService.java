package com.bookstore.bookstore_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public Categoria upDate(Integer id, Categoria obj) {
		Categoria objN = findById(id);
		objN.setNome(obj.getNome());
		objN.setDescricao(obj.getDescricao());

		return repository.save(objN);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.bookstore.bookstore_api.service.exception.DataIntegrityViolationException(
					"Categoria não pode ser deletada! Possui livros associados");
		}

	}
}
