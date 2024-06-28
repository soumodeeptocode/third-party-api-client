package com.scaler.demo.project.repository;

import com.scaler.demo.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    Optional<Category> findById(Long id);

    @Override
    List<Category> findAll();
}
