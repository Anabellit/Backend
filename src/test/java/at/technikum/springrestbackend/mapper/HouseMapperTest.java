package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Long id = 1L;
        User user = new User();
        user.setId(1L);

        House house = new House();
        house.setId(id);
        house.setTypeOfHouse("Apartment");
        house.setCountry("Austria");
        house.setTitle("Nice Apartment");
        house.setSubtitle("Cozy and Modern");
        house.setShortDescription("A small cozy apartment in the city center.");
        house.setLongDescription("This apartment is fully furnished with all modern amenities.");
        house.setHasWifi(true);
        house.setHasKitchen(true);
        house.setHasStreaming(true);
        house.setHasHomeOffice(false);
        house.setNearSupermarkets(true);
        house.setHasSelfCheckin(true);
        house.setUser(user);

        // Act
        HouseDto houseDto = houseMapper.toDto(house);

        // Assert
        assertEquals(id, houseDto.getId());
        assertEquals("Apartment", houseDto.getTypeOfHouse());
        assertEquals("Austria", houseDto.getCountry());
        assertEquals("Nice Apartment", houseDto.getTitle());
        assertEquals("Cozy and Modern", houseDto.getSubtitle());
        assertEquals("A small cozy apartment in the city center.", houseDto.getShortDescription());
        assertEquals("This apartment is fully furnished with all modern amenities.", houseDto.getLongDescription());
        assertEquals(true, houseDto.isHasWifi());
        assertEquals(true, houseDto.isHasKitchen());
        assertEquals(true, houseDto.isHasStreaming());
        assertEquals(false, houseDto.isHasHomeOffice());
        assertEquals(true, houseDto.isNearSupermarkets());
        assertEquals(true, houseDto.isHasSelfCheckin());
        assertEquals(1L, houseDto.getUserId());
    }

    @Test
    void whenDtoNoId_thenHouseHasId() {
        // Arrange
        HouseDto houseDto = new HouseDto();
        houseDto.setTypeOfHouse("Apartment");
        houseDto.setCountry("Austria");
        houseDto.setTitle("Nice Apartment");
        houseDto.setSubtitle("Cozy and Modern");
        houseDto.setShortDescription("A small cozy apartment in the city center.");
        houseDto.setLongDescription("This apartment is fully furnished with all modern amenities.");
        houseDto.setHasWifi(true);
        houseDto.setHasKitchen(true);
        houseDto.setHasStreaming(true);
        houseDto.setHasHomeOffice(false);
        houseDto.setNearSupermarkets(true);
        houseDto.setHasSelfCheckin(true);

        User user = new User();
        user.setId(1L);

        // Act
        House house = houseMapper.toEntity(houseDto, user);

        // Assert
        assertNotNull(house.getId()); // House should have a non-null ID
        assertEquals("Apartment", house.getTypeOfHouse());
        assertEquals("Austria", house.getCountry());
        assertEquals("Nice Apartment", house.getTitle());
        assertEquals("Cozy and Modern", house.getSubtitle());
        assertEquals("A small cozy apartment in the city center.", house.getShortDescription());
        assertEquals("This apartment is fully furnished with all modern amenities.", house.getLongDescription());
        assertEquals(true, house.isHasWifi());
        assertEquals(true, house.isHasKitchen());
        assertEquals(true, house.isHasStreaming());
        assertEquals(false, house.isHasHomeOffice());
        assertEquals(true, house.isNearSupermarkets());
        assertEquals(true, house.isHasSelfCheckin());
        assertEquals(user, house.getUser()); // Verify that the user is correctly set
    }

    @Test
    void whenDtoValue_thenHouseSameValue() {
        // Arrange
        Long id = 1L;
        UserDto userDto = new UserDto();
        userDto.setId(1L);

        HouseDto houseDto = new HouseDto();
        houseDto.setId(id);
        houseDto.setTypeOfHouse("Apartment");
        houseDto.setCountry("Austria");
        houseDto.setTitle("Nice Apartment");
        houseDto.setSubtitle("Cozy and Modern");
        houseDto.setShortDescription("A small cozy apartment in the city center.");
        houseDto.setLongDescription("This apartment is fully furnished with all modern amenities.");
        houseDto.setHasWifi(true);
        houseDto.setHasKitchen(true);
        houseDto.setHasStreaming(true);
        houseDto.setHasHomeOffice(false);
        houseDto.setNearSupermarkets(true);
        houseDto.setHasSelfCheckin(true);

        User user = new User();
        user.setId(1L);

        // Act
        House house = houseMapper.toEntity(houseDto, user);

        // Assert
        assertEquals(id, house.getId());
        assertEquals("Apartment", house.getTypeOfHouse());
        assertEquals("Austria", house.getCountry());
        assertEquals("Nice Apartment", house.getTitle());
        assertEquals("Cozy and Modern", house.getSubtitle());
        assertEquals("A small cozy apartment in the city center.", house.getShortDescription());
        assertEquals("This apartment is fully furnished with all modern amenities.", house.getLongDescription());
        assertEquals(true, house.isHasWifi());
        assertEquals(true, house.isHasKitchen());
        assertEquals(true, house.isHasStreaming());
        assertEquals(false, house.isHasHomeOffice());
        assertEquals(true, house.isNearSupermarkets());
        assertEquals(true, house.isHasSelfCheckin());
        assertEquals(user, house.getUser()); // Verify the user is correctly set
    }
}
