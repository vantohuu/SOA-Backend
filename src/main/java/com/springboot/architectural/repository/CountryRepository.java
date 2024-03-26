package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
