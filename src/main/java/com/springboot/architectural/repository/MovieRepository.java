package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Category;
import com.springboot.architectural.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT r FROM Movie r WHERE CONCAT(r.id, ' ', r.name) LIKE %?1%")
    public List<Movie> findAllFilter(String searchContent, Sort pageable);

    @Query("SELECT movie FROM Movie movie " +
            "join movie.categories category \n" +
            "WHERE CONCAT(movie.id, ' ', movie.name) LIKE %?1% and category.categoryId = ?2 ")
    public List<Movie> findAllFilterByCategory(String searchContent, Integer category_id, Sort pageable);

    @Query(value = "EXEC SelectTopMovie @t = ?1", nativeQuery = true)
    public List<Movie> getAllByTopNewMovie(Integer top);
    @Query("SELECT movie FROM Movie movie " +
            "join movie.categories category \n" +
            "WHERE CONCAT(movie.id, ' ', movie.name) LIKE %?1% and category.categoryId = ?2 ")
    public Page<Movie> paginationAndSortingByCategory(String searchContent, Integer category_id,  PageRequest pageRequest);
    @Query("SELECT movie FROM Movie movie " +
            "WHERE CONCAT(movie.id, ' ', movie.name) LIKE %?1% and movie.country.countryId = ?2 ")
    public Page<Movie> paginationAndSortingByCountry(String searchContent, Integer countryId,  PageRequest pageRequest);
    public List<Movie> findTop10ByEpisodesGreaterThanOrderByMovieIdDesc(int episodes) ;

    public List<Movie > findTop10ByEpisodesOrderByMovieIdDesc(int episodes);
    @Query(value = "select top(?1) * from Movie order by NEWID() ", nativeQuery = true)
    public List<Movie > findRandomMovie(int top);

}
