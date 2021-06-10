package com.bootcamp.desafio_quality.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HouseResponseDTO {

    @JsonProperty("prop_sqft")
    private double propSqft;

    @JsonProperty("prop_price")
    private double propPrice;

    @JsonProperty("prop_largest_room")
    private RoomDTO propLargestRoom;

    @JsonProperty("prop_room_list")
    private List<RoomDTO> propRoomList;

    public HouseResponseDTO() {
    }

    public double getPropSqft() {
        return propSqft;
    }

    public void setPropSqft(double propSqft) {
        this.propSqft = propSqft;
    }

    public double getPropPrice() {
        return propPrice;
    }

    public void setPropPrice(double propPrice) {
        this.propPrice = propPrice;
    }

    public RoomDTO getPropLargestRoom() {
        return propLargestRoom;
    }

    public void setPropLargestRoom(RoomDTO propLargestRoom) {
        this.propLargestRoom = propLargestRoom;
    }

    public List<RoomDTO> getPropRoomList() {
        return propRoomList;
    }

    public void setPropRoomList(List<RoomDTO> propRoomList) {
        this.propRoomList = propRoomList;
    }
}
