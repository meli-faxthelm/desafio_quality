package com.bootcamp.desafio_quality.util;

import com.bootcamp.desafio_quality.dto.HouseDTO;
import com.bootcamp.desafio_quality.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestGeneratorUtil {

    public static HouseDTO getHouseWith3Rooms(){
        List<RoomDTO> propRooms = new ArrayList<>();
        propRooms.add(new RoomDTO("Banheiro", 2.0, 1.0));
        propRooms.add(new RoomDTO("Cozinha", 3.0, 3.0));
        propRooms.add(new RoomDTO("Sala", 4.0, 3.0));

        return new HouseDTO("Casa amarela", "Brooklin", propRooms);
    }

}
