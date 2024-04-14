package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Comment;
import com.springboot.architectural.entity.History;
import com.springboot.architectural.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT comment FROM Comment comment " +
            "WHERE comment.comment LIKE %?1% and comment.movie.movieId = ?2 ")
    public Page<Comment> paginationAndSortingByMovie(String searchContent, Integer movieId, PageRequest pageRequest);
}
