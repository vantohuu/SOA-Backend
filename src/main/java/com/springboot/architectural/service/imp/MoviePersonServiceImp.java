package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.Movie_CategoryDTO;
import com.springboot.architectural.dto.Movie_PersonDTO;
import com.springboot.architectural.entity.*;
import com.springboot.architectural.mapper.MovieCategoryMapper;
import com.springboot.architectural.mapper.MoviePersonMapper;
import com.springboot.architectural.repository.*;
import com.springboot.architectural.service.MovieCategoryService;
import com.springboot.architectural.service.MoviePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoviePersonServiceImp implements MoviePersonService {
    @Autowired
    private MoviePersonRepository moviePersonRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Movie_PersonDTO getById(int id) {
        Optional<Movie_Person> entity = moviePersonRepository.findById(id);
        return entity.map(MoviePersonMapper.INSTANCE::moviePersonToMoviePersonDto).orElse(null);
    }

    public List<Movie_PersonDTO> getAll() {
        List<Movie_Person> list = moviePersonRepository.findAll();
        return list.stream().map(MoviePersonMapper.INSTANCE::moviePersonToMoviePersonDto).collect(Collectors.toList());
    }

    @Override
    public Movie_PersonDTO add(Movie_PersonDTO moviePersonDTO) {
        Movie_Person entity = MoviePersonMapper.INSTANCE.moviePersonDtoToMoviePerson(moviePersonDTO);
        if (moviePersonDTO.getMovieId() == null || moviePersonDTO.getPersonId() == null  ) return null;
        Optional<Movie> movie = movieRepository.findById(moviePersonDTO.getMovieId());
        Optional<Person> person = personRepository.findById(moviePersonDTO.getPersonId());
        if (movie.isEmpty() || person.isEmpty()) return null;
        entity.setPerson(person.get());
        entity.setMovie(movie.get());
        return  MoviePersonMapper.INSTANCE.moviePersonToMoviePersonDto(moviePersonRepository.save(entity));
    }

    @Override
    public Movie_PersonDTO update(Movie_PersonDTO moviePersonDTO) {
        System.out.println(moviePersonDTO);
        if (moviePersonDTO.getId() == null) return null;
        Optional<Movie_Person> checkRR = moviePersonRepository.findById(moviePersonDTO.getId());
        if (checkRR.isEmpty()) return  null;
        if (moviePersonDTO.getMovieId() == null || moviePersonDTO.getPersonId() == null  ) return null;
        Optional<Movie> movie = movieRepository.findById(moviePersonDTO.getMovieId());
        Optional<Person> person = personRepository.findById(moviePersonDTO.getPersonId());
        if (movie.isEmpty() || person.isEmpty()) return null;
        Movie_Person entity = MoviePersonMapper.INSTANCE.moviePersonDtoToMoviePerson(moviePersonDTO);
        entity.setMovie(movie.get());
        entity.setPerson(person.get());
        return  MoviePersonMapper.INSTANCE.moviePersonToMoviePersonDto(moviePersonRepository.save(entity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Movie_Person> r = moviePersonRepository.findById(id);
        if (r.isPresent())
        {
            moviePersonRepository.delete(r.get());
            return true;
        }
        return false;
    }


}
