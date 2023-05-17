package com.bookstore.bookstore_api.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.bookstore_api.domain.Livro;
import com.bookstore.bookstore_api.service.LivroService;
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	LivroService service;
    
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj){
		Livro newObj = service.update(id, obj); 
		return ResponseEntity.ok().body(newObj); 
	}
	
	@PatchMapping(value ="/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj){
		Livro newObj = service.update(id, obj); 
		return ResponseEntity.ok().body(newObj); 
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value ="categoria", defaultValue = "0") Integer id_cat,
			@RequestBody Livro obj ) {
		 Livro newObj = service.create(id_cat, obj); 
		 URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	}
}
