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

    public static String getHouseWith3RoomsAsJson() {
        return houseDTOToJson(getHouseWith3Rooms());
    }

    private static String houseDTOToJson(HouseDTO houseDTO) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"prop_name\": \"");
        sb.append(houseDTO.getPropName());
        sb.append("\", \"prop_district\": \"");
        sb.append(houseDTO.getPropDistrict());
        sb.append("\", \"prop_rooms\": [");
        for(RoomDTO roomDTO : houseDTO.getPropRooms()) {
            sb.append("{ \"room_name\": \"");
            sb.append(roomDTO.getRoomName());
            sb.append("\", ");
            sb.append("\"room_width\": ");
            sb.append(roomDTO.getRoomWidth());
            sb.append(", \"room_length\": ");
            sb.append(roomDTO.getRoomLength());
            sb.append(" },");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]}");


        return sb.toString();
    }

}
