package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CategoryDTO;
import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class );
    CountryDTO countryToCountryDto(Country country);
    Country countryDtoToCountry(CountryDTO countryDto);
}
