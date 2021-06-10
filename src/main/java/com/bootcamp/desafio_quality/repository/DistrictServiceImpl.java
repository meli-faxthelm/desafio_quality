package com.bootcamp.desafio_quality.repository;

import com.bootcamp.desafio_quality.exception.DistrictNotFoundException;
import com.bootcamp.desafio_quality.model.District;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DistrictServiceImpl implements DistrictRepository{

    final static Map<String, District> database = Map.of(
            "Moema", new District("Moema", 2000.0),
            "Brooklin", new District("Brooklin", 3000.0),
            "Faria Lima", new District("Faria Lima", 5000.0),
            "Osasco", new District("Osasco", 1500.0),
            "Paraiso", new District("Paraiso", 2800.0));


    @Override
    public District getDistrictByName(String name) {
        District result = database.get(name);
        if(result == null) {
            throw new DistrictNotFoundException();
        }
        return result;
    }
}
