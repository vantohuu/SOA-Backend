package com.springboot.architectural.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Movie")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;
    private String name;
    private String movie_content;
    private Integer episodes;
    private Integer movie_schedule;
    private String image;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    private  float star;
    private Integer price;
    private Integer views;
    private Integer status;
}
