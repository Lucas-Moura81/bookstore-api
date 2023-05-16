package com.bookstore.bookstore_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore_api.domain.Livro;
@Repository
public interface LivroRepository  extends JpaRepository<Livro, Integer>{

}
