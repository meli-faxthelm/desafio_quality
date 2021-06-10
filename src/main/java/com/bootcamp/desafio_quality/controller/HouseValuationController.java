package com.bootcamp.desafio_quality.controller;

import com.bootcamp.desafio_quality.dto.HouseDTO;
import com.bootcamp.desafio_quality.dto.HouseResponseDTO;
import com.bootcamp.desafio_quality.service.HouseValuationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class HouseValuationController {

    HouseValuationService houseValuationService;

    public HouseValuationController(HouseValuationService houseValuationService) {
        this.houseValuationService = houseValuationService;
    }

    @PostMapping("valuate")
    public ResponseEntity<HouseResponseDTO> houseAvaliation(@Valid @RequestBody HouseDTO houseDTO) {
        return ResponseEntity.status(200).body(houseValuationService.valuate(houseDTO));
    }
}
