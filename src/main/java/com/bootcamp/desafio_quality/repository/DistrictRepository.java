package com.bootcamp.desafio_quality.repository;

import com.bootcamp.desafio_quality.model.District;

public interface DistrictRepository {
    District findDistrictByName(String name);
}
