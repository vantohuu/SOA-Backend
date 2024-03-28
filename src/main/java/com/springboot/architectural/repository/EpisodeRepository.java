package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.entity.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    @Query("SELECT r FROM Episode r WHERE CONCAT(r.id, ' ', r.name) LIKE %?1%")
    public List<Episode> findAllFilter(String searchContent, Sort pageable);
}
