package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.mapper.MovieMapper;
import com.springboot.architectural.repository.CountryRepository;
import com.springboot.architectural.repository.MovieRepository;
import com.springboot.architectural.service.FileService;
import com.springboot.architectural.service.MovieService;
import com.springboot.architectural.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Locale;
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
    private StorageService storageService;
    @Override
    public MovieDTO getById(Integer id) {
        Optional<Movie> entity = movieRepository.findById(id);
        return entity.map(MovieMapper.INSTANCE::movieToMovieDto).orElse(null);
    }

    @Override
    public List<MovieDTO> getAll(String searchContent,String sortField , String typeSort) {
        Sort sorted = Sort.by(sortField.isEmpty() ? "movieId" : sortField );
        sorted = typeSort.toUpperCase(Locale.ROOT).equals("DESC") ? sorted.descending() : sorted.ascending();
        List<Movie> movies =  movieRepository.findAllFilter(searchContent, sorted);;
        return movies.stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getAllByCategory(String searchContent, String sortField, String typeSort, Integer category_id) {
        Sort sorted = Sort.by(sortField.isEmpty() ? "movieId" : sortField );
        sorted = typeSort.toUpperCase(Locale.ROOT).equals("DESC") ? sorted.descending() : sorted.ascending();
        List<Movie> movies =  movieRepository.findAllFilterByCategory(searchContent,category_id, sorted);;
        return movies.stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getAllByCountry(String searchContent, String sortField, String typeSort, Integer country_id) {
        Sort sorted = Sort.by(sortField.isEmpty() ? "movieId" : sortField );
        sorted = typeSort.toUpperCase(Locale.ROOT).equals("DESC") ? sorted.descending() : sorted.ascending();
        List<Movie> movies =  movieRepository.findAllFilterByCountry(searchContent,country_id, sorted);;
        return movies.stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getAllByTopNewMovie(Integer top) {
        List<Movie> movies =  movieRepository.getAllByTopNewMovie(top);;
        return movies.stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public MovieDTO add(MovieDTO movieDTO) {
        Movie entity = MovieMapper.INSTANCE.movieDtoToMovie(movieDTO);
        entity.setCountry(countryRepository.findById(movieDTO.getCountryId()).get());
        return  MovieMapper.INSTANCE.movieToMovieDto(movieRepository.save(entity));
    }

    @Override
    public MovieDTO update(MovieDTO movieDTO) {
        if (movieDTO.getMovieId() == null) return null;
        Optional<Movie> roomCheck = movieRepository.findById(movieDTO.getMovieId());
        Optional<Country> countryCheck = countryRepository.findById(movieDTO.getCountryId());
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
        String url =  storageService.uploadFile(multipartFile);
        movie.get().setImage(url);
        movieRepository.save(movie.get());
        return true;
    }


    @Override
    public List<MovieDTO> getPhimBo() {
        List<Movie> movies =  movieRepository.findTop10ByEpisodesGreaterThanOrderByMovieIdDesc(1);;
        return movies.stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getPhimLe() {
        List<Movie> movies =  movieRepository.findTop10ByEpisodesOrderByMovieIdDesc(1);;
        return movies.stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }
    @Override
    public List<MovieDTO> findAllWithPaginationAndSorting(String searchContent,int offset, int pageSize, String field){
        Page<Movie> movies = movieRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field).descending()));
        return  movies.getContent().stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }
    @Override
    public List<MovieDTO> findByCategoryWithPaginationAndSorting(String searchContent,Integer category_id,int offset, int pageSize, String field){
        Page<Movie> movies = movieRepository.paginationAndSortingByCategory(searchContent,category_id, PageRequest.of(offset, pageSize).withSort(Sort.by(field).descending()));
        return  movies.getContent().stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> findByCountryWithPaginationAndSorting(String searchContent,Integer country_id,int offset, int pageSize, String field){
        Page<Movie> movies = movieRepository.paginationAndSortingByCountry(searchContent,country_id, PageRequest.of(offset, pageSize).withSort(Sort.by(field).descending()));
        return  movies.getContent().stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getRandomMovie(Integer top)
    {
        List<Movie> movies =  movieRepository.findRandomMovie(top);;
        return movies.stream().map(MovieMapper.INSTANCE::movieToMovieDto).collect(Collectors.toList());
    }

}
