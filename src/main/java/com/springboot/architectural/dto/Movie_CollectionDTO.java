package com.springboot.architectural.dto;

import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie_CollectionDTO {
    private Integer id;
    private Integer movie_id;
    private String username;
    private Movie movie;
    private Movie_User movieUser;
}
