package com.bootcamp.desafio_quality.service;

import com.bootcamp.desafio_quality.dto.HouseDTO;
import com.bootcamp.desafio_quality.dto.HouseResponseDTO;
import com.bootcamp.desafio_quality.dto.RoomDTO;
import com.bootcamp.desafio_quality.model.District;
import com.bootcamp.desafio_quality.repository.DistrictRepository;
import com.bootcamp.desafio_quality.repository.DistrictRepositoryImpl;
import com.bootcamp.desafio_quality.util.TestGeneratorUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class HouseValuationServiceImplTest {

    static HouseValuationService houseValuationService;

    @BeforeAll
    static void init() {
        DistrictRepository districtRepository = mock(DistrictRepositoryImpl.class);
        houseValuationService = new HouseValuationServiceImpl(districtRepository);
        when(districtRepository.findDistrictByName("Brooklin")).thenReturn(new District("Brooklin", 3000.0));
    }

    @Test
    void shouldReturnHouseSqft() {
        HouseDTO testCase = TestGeneratorUtil.getHouseWith3Rooms();

        HouseResponseDTO houseResponseDTO = houseValuationService.valuate(testCase);

        assertEquals(23, houseResponseDTO.getPropSqft());
    }

    @Test
    void shouldReturnLargestRoom() {
        HouseDTO testCase = TestGeneratorUtil.getHouseWith3Rooms();

        HouseResponseDTO houseResponseDTO = houseValuationService.valuate(testCase);

        assertThat(houseResponseDTO.getPropLargestRoom())
                .usingRecursiveComparison()
                .isEqualTo(new RoomDTO("Sala", 4.0, 3.0));
    }

    @Test
    void shouldReturnSqftOfRooms() {
        HouseDTO testCase = TestGeneratorUtil.getHouseWith3Rooms();

        HouseResponseDTO houseResponseDTO = houseValuationService.valuate(testCase);

        List<Double> roomsSqft = houseResponseDTO.getPropRoomList().stream().map(RoomDTO::getSquareFeet).collect(Collectors.toList());
        Double[] expected = {2.0, 9.0 ,12.0};
        assertArrayEquals(expected, roomsSqft.toArray());
    }


}