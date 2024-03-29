package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.Movie_CategoryDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Category;
import com.springboot.architectural.mapper.MovieCategoryMapper;
import com.springboot.architectural.repository.CategoryRepository;
import com.springboot.architectural.repository.MovieCategoryRepository;
import com.springboot.architectural.repository.MovieRepository;
import com.springboot.architectural.service.MovieCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieCategoryServiceImp implements MovieCategoryService {
    @Autowired
    private MovieCategoryRepository movieCategoryRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Movie_CategoryDTO getById(Integer id) {
        Optional<Movie_Category> entity = movieCategoryRepository.findById(id);
        return entity.map(MovieCategoryMapper.INSTANCE::movieCategoryToMovieCategoryDto).orElse(null);
    }
    @Override
    public List<Movie_CategoryDTO> getAll() {
        List<Movie_Category> list = movieCategoryRepository.findAll();
//        System.out.println(list.get(0));
        return list.stream().map(MovieCategoryMapper.INSTANCE::movieCategoryToMovieCategoryDto).collect(Collectors.toList());
    }

    @Override
    public Movie_CategoryDTO add(Movie_CategoryDTO movieCategoryDTO) {
        Movie_Category entity = MovieCategoryMapper.INSTANCE.movieCategoryDtoToMovieCategory(movieCategoryDTO);
        if (movieCategoryDTO.getMovieId() == null || movieCategoryDTO.getCategoryId() == null  ) return null;
        Optional<Movie> movie = movieRepository.findById(movieCategoryDTO.getMovieId());
        Optional<Category> category = categoryRepository.findById(movieCategoryDTO.getCategoryId());
        if (movie.isEmpty() || category.isEmpty()) return null;
        if (!movieCategoryRepository.findByMovieAndCategory(movie.get(), category.get()).isEmpty()) return  null;
        entity.setCategory(category.get());
        entity.setMovie(movie.get());
        return  MovieCategoryMapper.INSTANCE.movieCategoryToMovieCategoryDto(movieCategoryRepository.save(entity));
    }

    @Override
    public Movie_CategoryDTO update(Movie_CategoryDTO movieCategoryDTO) {
        System.out.println(movieCategoryDTO);
        if (movieCategoryDTO.getId() == null) return null;
        Optional<Movie_Category> checkRR = movieCategoryRepository.findById(movieCategoryDTO.getId());
        if (checkRR.isEmpty()) return  null;
        if (movieCategoryDTO.getMovieId() == null || movieCategoryDTO.getCategoryId() == null  ) return null;
        Optional<Movie> movie = movieRepository.findById(movieCategoryDTO.getMovieId());
        Optional<Category> category = categoryRepository.findById(movieCategoryDTO.getCategoryId());
        if (movie.isEmpty() || category.isEmpty()) return null;
        Movie_Category entity = MovieCategoryMapper.INSTANCE.movieCategoryDtoToMovieCategory(movieCategoryDTO);
        entity.setMovie(movie.get());
        entity.setCategory(category.get());
        return  MovieCategoryMapper.INSTANCE.movieCategoryToMovieCategoryDto(movieCategoryRepository.save(entity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Movie_Category> r = movieCategoryRepository.findById(id);
        if (r.isPresent())
        {
            movieCategoryRepository.delete(r.get());
            return true;
        }
        return false;
    }


}
