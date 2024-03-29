package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {

}
