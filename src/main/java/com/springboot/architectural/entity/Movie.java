package com.springboot.architectural.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString
@Table(name = "Movie")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;
    private String name;
    @Column(name = "movie_content")
    private String movieContent;
    private Integer episodes;
    @Column(name = "movie_schedule")
    private Integer movieSchedule;
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
