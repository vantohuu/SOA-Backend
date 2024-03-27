package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.entity.Country;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T14:49:53+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDTO countryToCountryDto(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setCountry_id( country.getCountry_id() );
        countryDTO.setName( country.getName() );

        return countryDTO;
    }

    @Override
    public Country countryDtoToCountry(CountryDTO countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountry_id( countryDto.getCountry_id() );
        country.setName( countryDto.getName() );

        return country;
    }
}
