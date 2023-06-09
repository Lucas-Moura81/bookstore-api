package com.bookstore.bookstore_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore_api.domain.Categoria;
import com.bookstore.bookstore_api.domain.Livro;
import com.bookstore.bookstore_api.repositories.LivroRepository;
import com.bookstore.bookstore_api.service.exception.ObjectNotFoundException;

@Service
public class LivroService {
	@Autowired
	LivroRepository repository;
	@Autowired
	CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado!" + id + ", tipo: " + Livro.class.getName()));
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id); // validando
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Livro obj = findById(id);
		repository.delete(obj);
	}

}
