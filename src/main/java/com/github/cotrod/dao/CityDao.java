package com.github.cotrod.dao;

import com.github.cotrod.model.CityDto;

public interface CityDao {

    CityDto getCity(String cityName);

    CityDto create(CityDto cityDto);

    CityDto update(CityDto cityDto);

    void delete(Long id);
}
