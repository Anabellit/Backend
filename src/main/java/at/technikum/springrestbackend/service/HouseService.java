package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.mapper.HouseMapper;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;
    private final HouseMapper houseMapper;

    public List<HouseDto> getAllHouses() {
        return houseRepository.findAll().stream()
                .map(houseMapper::toDto)
                .collect(Collectors.toList());
    }

    public HouseDto createHouse(HouseDto houseDto) {
        House house = houseMapper.toEntity(houseDto);
        house = houseRepository.save(house);
        return houseMapper.toDto(house);
    }

    public HouseDto getHouseById(Long id) {
        Optional<House> house = houseRepository.findById(id);
        if (house.isPresent()) {
            return houseMapper.toDto(house.get());
        } else {
            throw new RuntimeException("House not found with id: " + id);
        }
    }


    public HouseDto updateHouse(Long id, HouseDto houseDto) {
        House existingHouse = houseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("House not found"));

        // Aktualisiere die Felder des bestehenden Hauses mit den neuen Daten
        existingHouse.setTypeOfHouse(houseDto.getTypeOfHouse());
        existingHouse.setCountry(houseDto.getCountry());
        existingHouse.setTitle(houseDto.getTitle());
        existingHouse.setSubtitle(houseDto.getSubtitle());
        existingHouse.setShortDescription(houseDto.getShortDescription());
        existingHouse.setLongDescription(houseDto.getLongDescription());
        existingHouse.setHasWifi(houseDto.isHasWifi());
        existingHouse.setHasKitchen(houseDto.isHasKitchen());
        existingHouse.setHasStreaming(houseDto.isHasStreaming());
        existingHouse.setHasHomeOffice(houseDto.isHasHomeOffice());
        existingHouse.setNearSupermarkets(houseDto.isNearSupermarkets());
        existingHouse.setHasSelfCheckin(houseDto.isHasSelfCheckin());

        // Speichere das aktualisierte Haus
        houseRepository.save(existingHouse);

        // Gib das aktualisierte Haus als DTO zurück
        return houseMapper.toDto(existingHouse);
    }
}

