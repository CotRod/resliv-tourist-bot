package com.github.cotrod.rest;

import com.github.cotrod.dao.CityDao;
import com.github.cotrod.model.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
@Transactional
public class CityRestController {

    private final CityDao cityDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityDto create(@RequestBody CityDto newCity) {
        return cityDao.create(newCity);
    }

    @PutMapping("/{cityId}")
    public CityDto update(@PathVariable Long cityId, @RequestBody CityDto cityDto) {
        cityDto.setId(cityId);
        return cityDao.update(cityDto);
    }

    @DeleteMapping("/{cityId}")
    public void delete(@PathVariable Long cityId) {
        cityDao.delete(cityId);
    }
}
