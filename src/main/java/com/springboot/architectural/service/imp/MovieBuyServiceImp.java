package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.Movie_BuyDTO;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Buy;
import com.springboot.architectural.entity.Movie_User;
import com.springboot.architectural.mapper.MovieBuyMapper;
import com.springboot.architectural.repository.MovieBuyRepository;
import com.springboot.architectural.repository.MovieRepository;
import com.springboot.architectural.repository.MovieUserRepository;
import com.springboot.architectural.service.MovieBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieBuyServiceImp implements MovieBuyService {
    @Autowired
    private MovieBuyRepository movieBuyRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieUserRepository movieUserRepository;

    @Override
    public Movie_BuyDTO getById(Integer id) {
        Optional<Movie_Buy> entity = movieBuyRepository.findById(id);
        return entity.map(MovieBuyMapper.INSTANCE::movieBuyToMovieBuyDto).orElse(null);
    }

    public List<Movie_BuyDTO> getAll() {
        List<Movie_Buy> list = movieBuyRepository.findAll();
        return list.stream().map(MovieBuyMapper.INSTANCE::movieBuyToMovieBuyDto).collect(Collectors.toList());
    }

    @Override
    public List<Movie_BuyDTO> getAllByMovieUser(String username) {
        if (username == null) return  null;
        Optional<Movie_User> movieUser = movieUserRepository.findById(username);
        if (movieUser.isEmpty()) return  null;
        List<Movie_Buy> list = movieBuyRepository.findByMovieUser(movieUser.get());
        return list.stream().map(MovieBuyMapper.INSTANCE::movieBuyToMovieBuyDto).collect(Collectors.toList());
    }

    @Override
    public Movie_BuyDTO add(Movie_BuyDTO movieBuyDTO) {
        Movie_Buy entity = MovieBuyMapper.INSTANCE.movieBuyDtoToMovieBuy(movieBuyDTO);
        if (movieBuyDTO.getMovieId() == null || movieBuyDTO.getUsername()== null  ) return null;
        Optional<Movie> movie = movieRepository.findById(movieBuyDTO.getMovieId());
        Optional<Movie_User> movieUser = movieUserRepository.findById(movieBuyDTO.getUsername());
        if (movie.isEmpty() || movieUser.isEmpty()) return null;
        if (!movieBuyRepository.findByMovieAndMovieUser(movie.get(), movieUser.get()).isEmpty()) return  null;
        entity.setMovieUser(movieUser.get());
        entity.setMovie(movie.get());
        return  MovieBuyMapper.INSTANCE.movieBuyToMovieBuyDto(movieBuyRepository.save(entity));
    }




    @Override
    public Movie_BuyDTO update(Movie_BuyDTO movieBuyDTO) {
        System.out.println(movieBuyDTO);
        if (movieBuyDTO.getId() == null) return null;
        Optional<Movie_Buy> checkRR = movieBuyRepository.findById(movieBuyDTO.getId());
        if (checkRR.isEmpty()) return  null;
        if (movieBuyDTO.getMovieId() == null || movieBuyDTO.getUsername() == null  ) return null;
        Optional<Movie> movie = movieRepository.findById(movieBuyDTO.getMovieId());
        Optional<Movie_User> person = movieUserRepository.findById(movieBuyDTO.getUsername());
        if (movie.isEmpty() || person.isEmpty()) return null;
        Movie_Buy entity =MovieBuyMapper.INSTANCE.movieBuyDtoToMovieBuy(movieBuyDTO);
        entity.setMovie(movie.get());
        entity.setMovieUser(person.get());
        return  MovieBuyMapper.INSTANCE.movieBuyToMovieBuyDto(movieBuyRepository.save(entity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Movie_Buy> r = movieBuyRepository.findById(id);
        if (r.isPresent())
        {
            movieBuyRepository.delete(r.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean checkMovieBuyIsExists(Integer movieId, String username) {
        if (movieId == null || username == null) return false;
        Optional<Movie> movie = movieRepository.findById(movieId);
        Optional<Movie_User> user = movieUserRepository.findById(username);
        if (movie.isEmpty() || user.isEmpty()) return false;
        Optional<Movie_Buy> movieBuy = movieBuyRepository.findByMovieAndMovieUser(movie.get(), user.get());
        return !movieBuy.isEmpty();
    }


    @Override
    public boolean deleteMovieBuyByMovieAndUser(Integer movieId, String username) {
        if (movieId == null || username == null) return false;
        Optional<Movie> movie = movieRepository.findById(movieId);
        Optional<Movie_User> user = movieUserRepository.findById(username);
        if (movie.isEmpty() || user.isEmpty()) return false;
        Optional<Movie_Buy> movieBuy = movieBuyRepository.findByMovieAndMovieUser(movie.get(), user.get());
        if (movieBuy.isEmpty()) return false;
        movieBuyRepository.deleteById(movieBuy.get().getId());
        return true;
    }
}
