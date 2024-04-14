package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.entity.Country;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-14T21:42:05+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDTO countryToCountryDto(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setCountryId( country.getCountryId() );
        countryDTO.setName( country.getName() );

        return countryDTO;
    }

    @Override
    public Country countryDtoToCountry(CountryDTO countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountryId( countryDto.getCountryId() );
        country.setName( countryDto.getName() );

        return country;
    }
}
