package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.model.HouseSwap;
import org.springframework.stereotype.Component;

@Component
public class HouseSwapMapper {

    // Mapping von Entity zu DTO
    public HouseSwapDto toDtoFromEntity(HouseSwap houseSwap) {
        HouseSwapDto houseSwapDto = new HouseSwapDto();
        houseSwapDto.setId(houseSwap.getId());
        houseSwapDto.setHouseId(houseSwap.getHouse().getId());
        houseSwapDto.setMessage(houseSwap.getMessage());
        houseSwapDto.setSwapStatus(houseSwap.getStatus()); // Mapping des Enum SwapStatus
        return houseSwapDto;
    }

    // Mapping von DTO zu Entity
    public HouseSwap toEntity(HouseSwapDto houseSwapDto, House house) {
        return new HouseSwap(
                houseSwapDto.getId(),
                house,
                houseSwapDto.getMessage(),
                houseSwapDto.getSwapStatus() // Mapping des Enum SwapStatus
        );
    }
}
