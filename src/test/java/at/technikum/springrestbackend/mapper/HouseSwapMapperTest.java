/*package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import at.technikum.springrestbackend.model.HouseSwap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

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
        String id = UUID.randomUUID().toString();
        HouseSwap houseSwap = new HouseSwap(id, "user1", "swapper1", "house1", "swapHouse1");

        // Act
        HouseSwapDto houseSwapDto = houseSwapMapper.toDto(houseSwap);

        // Assert
        assertEquals(id, houseSwapDto.getId());
        assertEquals("user1", houseSwapDto.getUser());
        assertEquals("swapper1", houseSwapDto.getSwapper());
        assertEquals("house1", houseSwapDto.getHouse());
        assertEquals("swapHouse1", houseSwapDto.getSwapHouse());
    }

    @Test
    void whenDtoNoId_thenHouseSwapHasId() {
        // Arrange
        HouseSwapDto houseSwapDto = new HouseSwapDto();
        houseSwapDto.setUser("user2");
        houseSwapDto.setSwapper("swapper2");
        houseSwapDto.setHouse("house2");
        houseSwapDto.setSwapHouse("swapHouse2");

        // Act
        HouseSwap houseSwap = houseSwapMapper.toEntity(houseSwapDto);

        // Assert
        assertNotNull(houseSwap.getId());
        assertEquals("user2", houseSwap.getUser());
        assertEquals("swapper2", houseSwap.getSwapper());
        assertEquals("house2", houseSwap.getHouse());
        assertEquals("swapHouse2", houseSwap.getSwapHouse());
    }

    @Test
    void whenDtoValue_thenHouseSwapSameValue() {
        // Arrange
        String id = UUID.randomUUID().toString();
        HouseSwapDto houseSwapDto = new HouseSwapDto(id, "user3", "swapper3", "house3", "swapHouse3");

        // Act
        HouseSwap houseSwap = houseSwapMapper.toEntity(houseSwapDto);

        // Assert
        assertEquals(id, houseSwap.getId());
        assertEquals("user3", houseSwap.getUser());
        assertEquals("swapper3", houseSwap.getSwapper());
        assertEquals("house3", houseSwap.getHouse());
        assertEquals("swapHouse3", houseSwap.getSwapHouse());
    }
}
*/