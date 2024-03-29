package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.Movie_CollectionDTO;
import com.springboot.architectural.entity.*;
import com.springboot.architectural.mapper.MovieCollectionMapper;
import com.springboot.architectural.repository.*;
import com.springboot.architectural.service.MovieCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieCollectionServiceImp implements MovieCollectionService {
    @Autowired
    private MovieCollectionRepository movieCollectionRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieUserRepository movieUserRepository;

    @Override
    public Movie_CollectionDTO getById(String id) {
        Optional<Movie_Collection> entity = movieCollectionRepository.findById(id);
        return entity.map(MovieCollectionMapper.INSTANCE::movieCollectionToMovieCollectionDto).orElse(null);
    }

    public List<Movie_CollectionDTO> getAll() {
        List<Movie_Collection> list = movieCollectionRepository.findAll();
        return list.stream().map(MovieCollectionMapper.INSTANCE::movieCollectionToMovieCollectionDto).collect(Collectors.toList());
    }

    @Override
    public Movie_CollectionDTO add(Movie_CollectionDTO moviePersonDTO) {
        Movie_Collection entity = MovieCollectionMapper.INSTANCE.movieCollectionDtoToMovieCollection(moviePersonDTO);
        if (moviePersonDTO.getMovieId() == null || moviePersonDTO.getUsername() == null  ) return null;
        Optional<Movie> movie = movieRepository.findById(moviePersonDTO.getMovieId());
        Optional<Movie_User> person = movieUserRepository.findById(moviePersonDTO.getUsername());
        if (movie.isEmpty() || person.isEmpty()) return null;
        entity.setMovieUser(person.get());
        entity.setMovie(movie.get());
        return  MovieCollectionMapper.INSTANCE.movieCollectionToMovieCollectionDto(movieCollectionRepository.save(entity));
    }

    @Override
    public Movie_CollectionDTO update(Movie_CollectionDTO movieCollectionDTO) {
        System.out.println(movieCollectionDTO);
        if (movieCollectionDTO.getId() == null) return null;
        Optional<Movie_Collection> checkRR = movieCollectionRepository.findById(movieCollectionDTO.getUsername());
        if (checkRR.isEmpty()) return  null;
        if (movieCollectionDTO.getMovieId() == null || movieCollectionDTO.getUsername() == null  ) return null;
        Optional<Movie> movie = movieRepository.findById(movieCollectionDTO.getMovieId());
        Optional<Movie_User> person = movieUserRepository.findById(movieCollectionDTO.getUsername());
        if (movie.isEmpty() || person.isEmpty()) return null;
        Movie_Collection entity = MovieCollectionMapper.INSTANCE.movieCollectionDtoToMovieCollection(movieCollectionDTO);
        entity.setMovie(movie.get());
        entity.setMovieUser(person.get());
        return  MovieCollectionMapper.INSTANCE.movieCollectionToMovieCollectionDto(movieCollectionRepository.save(entity));
    }

    @Override
    public boolean delete(String id) {
        Optional<Movie_Collection> r = movieCollectionRepository.findById(id);
        if (r.isPresent())
        {
            movieCollectionRepository.delete(r.get());
            return true;
        }
        return false;
    }


}
