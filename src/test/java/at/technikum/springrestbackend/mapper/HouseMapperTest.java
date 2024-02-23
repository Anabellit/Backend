package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.model.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HouseMapperTest {

    private HouseMapper houseMapper;

    @BeforeEach
    void setUp() {
        houseMapper = new HouseMapper();
    }

    @Test
    void whenHouseValue_thenDtoSameValue() {
        // Arrange
        String id = UUID.randomUUID().toString();
        House house = new House(id, "123 Main St", "Spacious house with garden");

        // Act
        HouseDto houseDto = houseMapper.toDto(house);

        // Assert
        assertEquals(id, houseDto.getId());
        assertEquals("123 Main St", houseDto.getAddress());
        assertEquals("Spacious house with garden", houseDto.getDescription());
    }

    @Test
    void whenDtoNoId_thenHouseHasId() {
        // Arrange
        HouseDto houseDto = new HouseDto();
        houseDto.setAddress("123 Main St");
        houseDto.setDescription("Spacious house with garden");

        // Act
        House house = houseMapper.toEntity(houseDto);

        // Assert
        assertNotNull(house.getId());
    }

    @Test
    void whenDtoValue_thenHouseSameValue() {
        // Arrange
        String id = UUID.randomUUID().toString();
        HouseDto houseDto = new HouseDto(id, "123 Main St", "Spacious house with garden", new UserDto());

        // Act
        House house = houseMapper.toEntity(houseDto);

        // Assert
        assertEquals(id, house.getId());
        assertEquals("123 Main St", house.getAddress());
        assertEquals("Spacious house with garden", house.getDescription());
    }
}
