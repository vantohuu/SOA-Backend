package com.springboot.architectural.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Entity
@Data
@Table(name = "Person")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer person_id;
    private String name;
    private Integer gender;
    private Date day_of_birth;
    private String image;
    private String describe;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
