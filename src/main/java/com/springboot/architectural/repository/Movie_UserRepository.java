package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Movie_User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Movie_UserRepository extends JpaRepository<Movie_User, String> {

}
