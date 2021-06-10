package com.bootcamp.desafio_quality.service;

import com.bootcamp.desafio_quality.dto.HouseDTO;
import com.bootcamp.desafio_quality.dto.HouseResponseDTO;

public interface HouseValuationService {
    HouseResponseDTO valuate(HouseDTO houseDTO);
}
