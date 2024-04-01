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
    @Column(name = "person_id")
    private Integer personId;
    private String name;
    private Boolean gender;
    @Column(name = "day_of_birth")
    private Date dayOfBirth;
    private String image;
    private String describe;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
