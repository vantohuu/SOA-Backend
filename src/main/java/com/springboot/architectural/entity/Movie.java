package com.springboot.architectural.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @OneToMany(mappedBy = "movie")
    List<Episode> episodeList;;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Movie_Category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Movie_Person",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> persons;
}
