package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.mapper.MovieMapper;
import com.springboot.architectural.repository.CountryRepository;
import com.springboot.architectural.repository.MovieRepository;
import com.springboot.architectural.service.FileService;
import com.springboot.architectural.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImp implements MovieService {
    @Value("${fileUpload.rootPatch}")
    private String rootPatch;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private FileService fileService;
    @Override
    public MovieDTO getById(Integer id) {
        Optional<Movie> entity = movieRepository.findById(id);
        return entity.map(MovieMapper.INSTANCE::movieToMovieDto).orElse(null);
    }

    @Override
    public List<MovieDTO> getAll(String searchContent,String sortField, String typeSort) {
        Sort sorted = Sort.by(sortField.isEmpty() ? "movie_id" : sortField );
        sorted = typeSort.equals("des") ? sorted.descending() : sorted.ascending();
        List<Movie> movies =  movieRepository.findAllFilter(searchContent, sorted);;
        return movies.stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public MovieDTO add(MovieDTO movieDTO) {
        Movie entity = MovieMapper.INSTANCE.movieDtoToMovie(movieDTO);
        entity.setCountry(countryRepository.findById(movieDTO.getCountry_id()).get());
        return  MovieMapper.INSTANCE.movieToMovieDto(movieRepository.save(entity));
    }

    @Override
    public MovieDTO update(MovieDTO movieDTO) {
        if (movieDTO.getMovie_id() == null) return null;
        Optional<Movie> roomCheck = movieRepository.findById(movieDTO.getMovie_id());
        Optional<Country> countryCheck = countryRepository.findById(movieDTO.getCountry_id());
        if (roomCheck.isEmpty() || countryCheck.isEmpty()) return  null;
        Movie entity = MovieMapper.INSTANCE.movieDtoToMovie(movieDTO);
        entity.setCountry(countryCheck.orElse(null));
        return  MovieMapper.INSTANCE.movieToMovieDto(movieRepository.save(entity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Movie> r = movieRepository.findById(id);
        if (r.isPresent())
        {
            movieRepository.delete(r.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean uploadImg(MultipartFile multipartFile, Integer id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) return  false;
        String url =  rootPatch + "/" + multipartFile.getOriginalFilename();
        movie.get().setImage(url);
        movieRepository.save(movie.get());
        return fileService.save(multipartFile);
    }
}
