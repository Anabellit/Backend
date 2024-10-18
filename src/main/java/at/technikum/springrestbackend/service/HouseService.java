package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.mapper.HouseMapper;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.HouseRepository;
import at.technikum.springrestbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;
    private final UserRepository userRepository;
    private final HouseMapper houseMapper;

    public List<HouseDto> getAllHouses() {
        return houseRepository.findAll().stream()
                .map(houseMapper::toDto)
                .collect(Collectors.toList());
    }

    public HouseDto getHouseById(Long id) {
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("House not found"));
        return houseMapper.toDto(house);
    }

    public HouseDto createHouse(HouseDto houseDto) {
        User user = userRepository.findById(houseDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        House house = houseMapper.toEntity(houseDto, user);
        house = houseRepository.save(house);
        return houseMapper.toDto(house);
    }

    public HouseDto updateHouse(Long id, HouseDto houseDto) {
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("House not found"));

        User user = userRepository.findById(houseDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        house = houseMapper.toEntity(houseDto, user);
        house.setId(id);  // Sicherstellen, dass die ID nicht überschrieben wird
        house = houseRepository.save(house);
        return houseMapper.toDto(house);
    }

    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }
}
