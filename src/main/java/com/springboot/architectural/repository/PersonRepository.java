package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("SELECT r FROM Person r WHERE CONCAT(r.id, ' ', r.name) LIKE %?1%")
    public List<Person> findAllFilter(String searchContent, Sort pageable);
}
