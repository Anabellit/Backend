package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import at.technikum.springrestbackend.model.HouseSwap;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HouseSwapMapper {

    public HouseSwapDto toDto(HouseSwap houseSwap) {
        HouseSwapDto houseSwapDto = new HouseSwapDto();
        houseSwapDto.setId(houseSwap.getId());
        houseSwapDto.setUser(houseSwap.getUser());
        houseSwapDto.setSwapper(houseSwap.getSwapper());
        houseSwapDto.setHouse(houseSwap.getHouse());
        houseSwapDto.setSwapHouse(houseSwap.getSwapHouse());
        return houseSwapDto;
    }

    public HouseSwap toEntity(HouseSwapDto houseSwapDto) {
        if (houseSwapDto.getId() == null) {
            return new HouseSwap(
                    UUID.randomUUID().toString(),
                    houseSwapDto.getUser(),
                    houseSwapDto.getSwapper(),
                    houseSwapDto.getHouse(),
                    houseSwapDto.getSwapHouse()
            );
        }

        return new HouseSwap(
                houseSwapDto.getId(),
                houseSwapDto.getUser(),
                houseSwapDto.getSwapper(),
                houseSwapDto.getHouse(),
                houseSwapDto.getSwapHouse()
        );
    }
}



