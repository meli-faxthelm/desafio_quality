package com.bootcamp.desafio_quality.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
public class HouseDTO {

    @JsonProperty("prop_name")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "[A-Z].*", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    private String name;

    @JsonProperty("prop_district")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    @NotBlank(message = "O bairro não pode estar vazio.")
    private String propDistrict;

    @JsonProperty("prop_rooms")
    @Size(min = 1)
    @Valid
    private List<RoomDTO> propRooms;

    public HouseDTO() {
    }

    public HouseDTO(String name, String propDistrict, List<RoomDTO> propRooms) {
        this.name = name;
        this.propDistrict = propDistrict;
        this.propRooms = propRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropDistrict() {
        return propDistrict;
    }

    public void setPropDistrict(String propDistrict) {
        this.propDistrict = propDistrict;
    }

    public List<RoomDTO> getPropRooms() {
        return propRooms;
    }

    public void setPropRooms(List<RoomDTO> propRooms) {
        this.propRooms = propRooms;
    }
}
