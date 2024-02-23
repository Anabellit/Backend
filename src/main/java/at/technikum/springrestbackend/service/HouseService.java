package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.HouseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {

    private final List<HouseDto> houses = new ArrayList<>();

    public List<HouseDto> getAllHouses() {
        return houses;
    }

    public HouseDto getHouseById(Long id) {
        return null; // Dummy-Rückgabewert
    }

    public HouseDto createHouse(HouseDto houseDto) {
        return houseDto; // Dummy-Rückgabewert
    }

    public HouseDto updateHouse(Long id, HouseDto houseDto) {
        return houseDto;
    }

    public void deleteHouse(Long id) {
    }
}
