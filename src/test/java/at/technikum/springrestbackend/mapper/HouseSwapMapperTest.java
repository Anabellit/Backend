package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.model.HouseSwap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HouseSwapMapperTest {

    private HouseSwapMapper houseSwapMapper;

    @BeforeEach
    void setUp() {
        houseSwapMapper = new HouseSwapMapper();
    }

    @Test
    void whenHouseSwapValue_thenDtoSameValue() {
        // Arrange
        Long id = 1L;
        House house = new House();
        house.setId(1L);

        HouseSwap houseSwap = new HouseSwap();
        houseSwap.setId(id);
        houseSwap.setHouse(house);
        houseSwap.setMessage("House swap request");
        houseSwap.setStatus("Pending");

        // Act
        HouseSwapDto houseSwapDto = houseSwapMapper.toDto(houseSwap);

        // Assert
        assertEquals(id, houseSwapDto.getId());
        assertEquals(1L, houseSwapDto.getHouseId());
        assertEquals("House swap request", houseSwapDto.getMessage());
        assertEquals("Pending", houseSwapDto.getStatus());
    }

    @Test
    void whenDtoNoId_thenHouseSwapHasId() {
        // Arrange
        HouseSwapDto houseSwapDto = new HouseSwapDto();
        houseSwapDto.setMessage("New house swap request");
        houseSwapDto.setStatus("Pending");

        House house = new House();
        house.setId(2L);

        // Act
        HouseSwap houseSwap = houseSwapMapper.toEntity(houseSwapDto, house);

        // Assert
        assertNotNull(houseSwap.getId()); // HouseSwap should have a non-null ID
        assertEquals("New house swap request", houseSwap.getMessage());
        assertEquals("Pending", houseSwap.getStatus());
        assertEquals(house, houseSwap.getHouse()); // House should be correctly set
    }

    @Test
    void whenDtoValue_thenHouseSwapSameValue() {
        // Arrange
        Long id = 3L;
        House house = new House();
        house.setId(3L);

        HouseSwapDto houseSwapDto = new HouseSwapDto();
        houseSwapDto.setId(id);
        houseSwapDto.setHouseId(house.getId());
        houseSwapDto.setMessage("Another swap request");
        houseSwapDto.setStatus("Accepted");

        // Act
        HouseSwap houseSwap = houseSwapMapper.toEntity(houseSwapDto, house);

        // Assert
        assertEquals(id, houseSwap.getId());
        assertEquals(house, houseSwap.getHouse());
        assertEquals("Another swap request", houseSwap.getMessage());
        assertEquals("Accepted", houseSwap.getStatus());
    }
}
