package com.springboot.architectural.dto;

import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie_PersonDTO {
    private Integer id;
    private Integer movie_id;
    private Integer person_id;
    private Movie movie;
    private Person person;
}
