package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.model.HouseSwap;
import org.springframework.stereotype.Component;

@Component
public class HouseSwapMapper {

    // Mapping von Entity zu DTO
    public HouseSwapDto toDto(HouseSwap houseSwap) {
        HouseSwapDto houseSwapDto = new HouseSwapDto();
        houseSwapDto.setId(houseSwap.getId());
        houseSwapDto.setHouseId(houseSwap.getHouse().getId());  // Hole die ID des Hauses
        houseSwapDto.setMessage(houseSwap.getMessage());
        houseSwapDto.setStatus(houseSwap.getStatus());  // Mapping des Status
        return houseSwapDto;
    }

    // Mapping von DTO zu Entity
    public HouseSwap toEntity(HouseSwapDto houseSwapDto, House house) {
        return new HouseSwap(
                houseSwapDto.getId(),
                house,  // Setze das zugehörige House
                houseSwapDto.getMessage(),
                houseSwapDto.getStatus()  // Status aus DTO übernehmen
        );
    }
}
