package com.springboot.architectural.dto;

import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie_CollectionDTO {
    private Integer id;
    private Integer movieId;
    private String movieName;
    private String imageMovie;
    private String username;
    private Date time;
//    private MovieDTO movie;

}
