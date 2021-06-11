package com.bootcamp.desafio_quality.integration;

import com.bootcamp.desafio_quality.util.TestGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldReturnHouseSqftResponseWithHouseOf3Rooms() throws Exception {
        String request = TestGeneratorUtil.getHouseWith3RoomsAsJson();
        this.mockMvc.perform(post("/valuate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath(("$.prop_sqft")).value(23.0));
    }

    @Test
    void shouldReturnHouseLargestRoomResponseWithHouseOf3Rooms() throws Exception {
        String request = TestGeneratorUtil.getHouseWith3RoomsAsJson();
        this.mockMvc.perform(post("/valuate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath(("$.prop_largest_room.room_name")).value("Sala"))
                .andExpect((jsonPath(("$.prop_largest_room.room_width")).value(4.0)))
                .andExpect((jsonPath(("$.prop_largest_room.room_length")).value(3.0)))
                .andExpect((jsonPath(("$.prop_largest_room.room_sqft")).value(12.0)));
    }

    @Test
    void shouldReturnSqftOfRooms() throws Exception {
        String request = TestGeneratorUtil.getHouseWith3RoomsAsJson();
        this.mockMvc.perform(post("/valuate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath(("$.prop_room_list[0].room_sqft")).value(2.0))
                .andExpect(jsonPath(("$.prop_room_list[1].room_sqft")).value(9.0))
                .andExpect(jsonPath(("$.prop_room_list[2].room_sqft")).value(12.0));
    }

}
