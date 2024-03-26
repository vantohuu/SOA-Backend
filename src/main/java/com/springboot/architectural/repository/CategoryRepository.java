package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
