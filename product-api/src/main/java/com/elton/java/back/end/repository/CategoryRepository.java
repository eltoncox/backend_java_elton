package com.elton.java.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elton.java.back.end.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
