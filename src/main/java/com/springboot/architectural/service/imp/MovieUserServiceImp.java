package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.Movie_UserDTO;
import com.springboot.architectural.entity.Movie_User;
import com.springboot.architectural.entity.Role;
import com.springboot.architectural.mapper.MovieUserMapper;
import com.springboot.architectural.repository.MovieUserRepository;
import com.springboot.architectural.repository.RoleRepository;
import com.springboot.architectural.security.JwtTokenProvider;
import com.springboot.architectural.service.FileService;
import com.springboot.architectural.service.MovieUserService;
import com.springboot.architectural.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieUserServiceImp implements MovieUserService {
    @Value("${fileUpload.rootPatch}")
    private String rootPatch;
    @Autowired
    private MovieUserRepository movieUserRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private StorageService storageService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Movie_UserDTO getById(String username) {
        Optional<Movie_User> entity = movieUserRepository.findById(username);
        return entity.map(MovieUserMapper.INSTANCE::movieUserToMovieUserDto).orElse(null);
    }
    @Override
    public Movie_UserDTO getByEmail(String email) {
        Optional<Movie_User> entity = movieUserRepository.findByEmail(email);
        return entity.map(MovieUserMapper.INSTANCE::movieUserToMovieUserDto).orElse(null);
    }

    @Override
    public List<Movie_UserDTO> getAll(String searchContent,String sortField, String typeSort) {
        Sort sorted = Sort.by(sortField.isEmpty() ? "name" : sortField );
        sorted = typeSort.toUpperCase(Locale.ROOT).equals("DESC") ? sorted.descending() : sorted.ascending();
        List<Movie_User> movieUsers =  movieUserRepository.findAll();;
        return movieUsers.stream().map(MovieUserMapper.INSTANCE::movieUserToMovieUserDto).collect(Collectors.toList());
    }

    @Override
    public Movie_UserDTO add(Movie_UserDTO movieDTO) {
        Movie_User entity = MovieUserMapper.INSTANCE.movieUserDtoToMovieUser(movieDTO);
        entity.setRole(roleRepository.findById(movieDTO.getRoleId()).orElse(null));
        entity.setPassword(passwordEncoder.encode(movieDTO.getPassword()));
        if (entity.getRole() == null) return  null;
        return  MovieUserMapper.INSTANCE.movieUserToMovieUserDto(movieUserRepository.save(entity));
    }

    @Override
    public Movie_UserDTO update(Movie_UserDTO movieDTO) {
        if (movieDTO.getUsername() == null) return null;
        Optional<Movie_User> movie_userCheck = movieUserRepository.findById(movieDTO.getUsername());
        Optional<Role> roleCheck = roleRepository.findById(movieDTO.getRoleId());
        if (movie_userCheck.isEmpty() || roleCheck.isEmpty()) return  null;
        Movie_User entity = MovieUserMapper.INSTANCE.movieUserDtoToMovieUser(movieDTO);
        entity.setRole(roleCheck.orElse(null));
        return  MovieUserMapper.INSTANCE.movieUserToMovieUserDto(movieUserRepository.save(entity));
    }

    @Override
    public boolean delete(String username) {
        Optional<Movie_User> r = movieUserRepository.findById(username);
        if (r.isPresent())
        {
            movieUserRepository.delete(r.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean uploadImg(MultipartFile multipartFile, String username) {
        Optional<Movie_User> movie_user = movieUserRepository.findById(username);
        if (username.isEmpty()) return  false;
        String url =  storageService.uploadFile(multipartFile);
        movie_user.get().setAvatar(url);
        movieUserRepository.save(movie_user.get());
        return true;
    }
}
