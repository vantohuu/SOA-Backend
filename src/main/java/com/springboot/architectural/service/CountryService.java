package com.springboot.architectural.service;

import com.springboot.architectural.dto.CategoryDTO;
import com.springboot.architectural.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    CountryDTO getById(int id);
    List<CountryDTO> getAll();
    CountryDTO add(CountryDTO countryDTO);
    CountryDTO update(CountryDTO countryDTO);
    boolean delete(Integer id);
}
