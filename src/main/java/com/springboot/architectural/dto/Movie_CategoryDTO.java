package com.springboot.architectural.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie_CategoryDTO {
    private Integer id;
    private Integer movieId;
    private Integer categoryId;
//    private MovieDTO movie;
//    private CategoryDTO category;

}
