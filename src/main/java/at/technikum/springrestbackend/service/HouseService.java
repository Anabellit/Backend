package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.exception.EntityNotFoundException;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    public House getHouseById(String id) {
        return houseRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public House createHouse(House house) {
        return houseRepository.save(house); // Dummy-Rückgabewert
    }

    /*public HouseDto updateHouse(String id, HouseDto houseDto) {
        return houseRepository.;
    }*/

    public void deleteHouse(String id) {
        houseRepository.deleteById(id);
    }
}
