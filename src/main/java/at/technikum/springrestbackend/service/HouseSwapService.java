package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import at.technikum.springrestbackend.mapper.HouseSwapMapper;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.model.HouseSwap;
import at.technikum.springrestbackend.repository.HouseRepository;
import at.technikum.springrestbackend.repository.HouseSwapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HouseSwapService {

    private final HouseSwapRepository houseSwapRepository;
    private final HouseRepository houseRepository;
    private final HouseSwapMapper houseSwapMapper;

    // Methode zum Abrufen aller HouseSwaps mit Hausdetails
    public List<HouseSwapDto> getAllHouseSwapsWithDetails() {
        List<HouseSwap> houseSwaps = houseSwapRepository.findAll();

        return houseSwaps.stream()
                .map(houseSwapMapper::toDto)
                .collect(Collectors.toList());
    }

    // Methode zum Abrufen eines einzelnen HouseSwap mit Hausdetails
    public HouseSwapDto getHouseSwapWithDetailsById(Long id) {
        HouseSwap houseSwap = houseSwapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HouseSwap not found"));

        return houseSwapMapper.toDto(houseSwap);  // Mappe die Entität zu einem DTO
    }

    // Methode zum Erstellen eines neuen HouseSwap
    public HouseSwapDto createHouseSwap(HouseSwapDto houseSwapDto) {
        // Hole das zugehörige House
        House house = houseRepository.findById(houseSwapDto.getHouseId())
                .orElseThrow(() -> new RuntimeException("House not found"));

        // Mapping von DTO zu Entity
        HouseSwap houseSwap = houseSwapMapper.toEntity(houseSwapDto, house);

        // Speichere den HouseSwap in der Datenbank
        HouseSwap savedSwap = houseSwapRepository.save(houseSwap);

        // Rückgabe des gespeicherten HouseSwap als DTO
        return houseSwapMapper.toDto(savedSwap);
    }

    // Methode zum Aktualisieren eines HouseSwap
    public HouseSwapDto updateHouseSwap(Long id, HouseSwapDto houseSwapDto) {
        // Hole das bestehende HouseSwap
        HouseSwap houseSwap = houseSwapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HouseSwap not found"));

        // Hole das zugehörige House aus dem DTO
        House house = houseRepository.findById(houseSwapDto.getHouseId())
                .orElseThrow(() -> new RuntimeException("House not found"));

        // Aktualisiere die Daten im HouseSwap
        houseSwap.setStatus(houseSwapDto.getStatus());  // Aktualisiere den Status
        houseSwap.setMessage(houseSwapDto.getMessage());  // Aktualisiere die Nachricht
        houseSwap.setHouse(house);  // Aktualisiere das zugehörige Haus

        // Speichere die aktualisierten Daten
        HouseSwap updatedSwap = houseSwapRepository.save(houseSwap);

        // Rückgabe des aktualisierten HouseSwap als DTO
        return houseSwapMapper.toDto(updatedSwap);
    }

    // Methode zum Löschen eines HouseSwap
    public void deleteHouseSwap(Long id) {
        houseSwapRepository.deleteById(id);
    }
}
