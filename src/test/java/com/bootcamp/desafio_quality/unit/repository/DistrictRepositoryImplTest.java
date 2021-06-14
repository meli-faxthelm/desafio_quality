package com.bootcamp.desafio_quality.unit.repository;

import com.bootcamp.desafio_quality.exception.DistrictNotFoundException;
import com.bootcamp.desafio_quality.model.District;
import com.bootcamp.desafio_quality.repository.DistrictRepository;
import com.bootcamp.desafio_quality.repository.DistrictRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class DistrictRepositoryImplTest {

    static DistrictRepository districtRepository;

    @BeforeAll
    static void init(){
        districtRepository = new DistrictRepositoryImpl();
    }

    @Test
    void shouldReturnDistrtict(){
        String districtName = "Brooklin";
        District district = districtRepository.findDistrictByName(districtName);

        assertEquals(districtName, district.getName());
    }

    @Test
    void shouldReturnDistrictNotFoundException() {
        String districtName = "Aricanduva";

        assertThrows(DistrictNotFoundException.class, () -> districtRepository.findDistrictByName(districtName));
    }

}