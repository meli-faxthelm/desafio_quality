package com.bootcamp.desafio_quality.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Validated
public class RoomDTO {

    @JsonProperty("room_name")
    @Size(max =  30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    @Pattern(regexp = "[A-Z].*", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @NotBlank(message = "O campo não pode estar vazio.")
    private String roomName;

    @JsonProperty("room_width")
    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private double roomWidth;

    @JsonProperty("room_length")
    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private double roomLength;

    public RoomDTO() {
    }

    public RoomDTO(String roomName, double roomWidth, double roomLength) {
        this.roomName = roomName;
        this.roomWidth = roomWidth;
        this.roomLength = roomLength;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getRoomWidth() {
        return roomWidth;
    }

    public void setRoomWidth(double roomWidth) {
        this.roomWidth = roomWidth;
    }

    public double getRoomLength() {
        return roomLength;
    }

    public void setRoomLength(double roomLength) {
        this.roomLength = roomLength;
    }

    @JsonProperty("room_sqft")
    public double getSquareFeet() {
        return this.roomLength * this.roomWidth;
    }
}
