package com.springboot.architectural.dto;

import com.springboot.architectural.entity.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    @Id
    private Integer movie_id;
    private String name;
    private String movie_content;
    private Integer episodes;
    private Integer movie_schedule;
    private String image;
    private Integer country_id;
    private Country country;
    private  float star;
    private Integer price;
    private Integer views;
    private Integer status;
}
