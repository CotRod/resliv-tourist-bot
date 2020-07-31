package com.github.cotrod.dao.impl;

import com.github.cotrod.dao.CityDao;
import com.github.cotrod.dao.entity.City;
import com.github.cotrod.dao.repository.CityRepository;
import com.github.cotrod.model.CityDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CityDaoImpl implements CityDao {

    private final CityRepository cityRepository;
    private final ModelMapper mapper;

    @Override
    public CityDto getCity(String cityName) {
        return cityRepository.findByCityName(cityName)
                .map(city -> mapper.map(city, CityDto.class))
                .orElse(null);
    }

    @Override
    public CityDto create(CityDto cityDto) {
        final City newCity = mapper.map(cityDto, City.class);
        return mapper.map(cityRepository.save(newCity), CityDto.class);
    }

    @Override
    public CityDto update(CityDto cityDto) {
        return cityRepository.findById(cityDto.getId())
                .map(city -> updateCity(cityDto, city))
                .map(city -> mapper.map(city, CityDto.class))
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    private City updateCity(CityDto cityDto, City city) {
        mapper.map(cityDto, city);
        return city;
    }
}
