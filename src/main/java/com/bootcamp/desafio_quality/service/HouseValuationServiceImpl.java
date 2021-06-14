package com.bootcamp.desafio_quality.service;

import com.bootcamp.desafio_quality.dto.HouseDTO;
import com.bootcamp.desafio_quality.dto.HouseResponseDTO;
import com.bootcamp.desafio_quality.dto.RoomDTO;
import com.bootcamp.desafio_quality.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseValuationServiceImpl implements HouseValuationService {

    DistrictRepository districtRepository;

    public HouseValuationServiceImpl(DistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }

    @Override
    public HouseResponseDTO valuate(HouseDTO houseDTO) {
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();

        houseResponseDTO.setPropSqft(calculateHouseSquareFeet(houseDTO.getPropRooms()));
        houseResponseDTO.setPropPrice(calculatePrice(houseResponseDTO.getPropSqft(), houseDTO.getPropDistrict()));
        houseResponseDTO.setPropLargestRoom(calculateLargestRoom(houseDTO.getPropRooms()));
        houseResponseDTO.setPropRoomList(houseDTO.getPropRooms());

        return houseResponseDTO;
    }

    private double calculateHouseSquareFeet(List<RoomDTO> rooms) {
        return rooms.stream().map(RoomDTO::getSquareFeet).reduce(0d,Double::sum);
    }

    private double calculatePrice(double propSqft, String district) {
        return districtRepository.findDistrictByName(district).getSqftPrice() * propSqft;
    }

    private RoomDTO calculateLargestRoom(List<RoomDTO> rooms) {
        return rooms.stream().max(Comparator.comparing(RoomDTO::getSquareFeet)).get();
    }




}
