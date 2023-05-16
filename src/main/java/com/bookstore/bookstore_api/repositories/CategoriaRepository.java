package com.bookstore.bookstore_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore_api.domain.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
