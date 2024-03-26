package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.CategoryDTO;
import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.mapper.CategoryMapper;
import com.springboot.architectural.mapper.CountryMapper;
import com.springboot.architectural.repository.CategoryRepository;
import com.springboot.architectural.repository.CountryRepository;
import com.springboot.architectural.service.CategoryService;
import com.springboot.architectural.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImp implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryDTO getById(int id) {
        Optional<Country> country = countryRepository.findById(id);
        return country.map(CountryMapper.INSTANCE::countryToCountryDto).orElse(null);
    }

    public List<CountryDTO> getAll() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream().map(CountryMapper.INSTANCE::countryToCountryDto).collect(Collectors.toList());
    }

    @Override
    public CountryDTO add(CountryDTO countryDTO) {
        Country country = CountryMapper.INSTANCE.countryDtoToCountry(countryDTO);
        if (countryDTO.getName() == null ) return null;
        return  CountryMapper.INSTANCE.countryToCountryDto(countryRepository.save(country));
    }

    @Override
    public CountryDTO update(CountryDTO countryDTO) {
        Optional<Country> checkRR = countryRepository.findById(countryDTO.getCountry_id());
        if (checkRR.isEmpty()) return null;
        Country entity = CountryMapper.INSTANCE.countryDtoToCountry(countryDTO);
        return  CountryMapper.INSTANCE.countryToCountryDto(countryRepository.save(entity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Country> c = countryRepository.findById(id);
        if (c.isPresent())
        {
            countryRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
