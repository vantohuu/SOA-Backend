package com.springboot.architectural.dto;

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
    private Integer movie_id;
    private Integer category_id;
    private Movie movie;
    private Category category;

}
