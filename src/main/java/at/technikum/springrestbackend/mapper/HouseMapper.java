package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.model.House;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HouseMapper {

    public HouseDto toDto(House house) {
        HouseDto houseDto = new HouseDto();
        houseDto.setId(house.getId());
        houseDto.setAddress(house.getAddress());
        houseDto.setDescription(house.getDescription());

        return houseDto;
    }

    public House toEntity(HouseDto houseDto) {
        if (houseDto.getId() == null) {
            return new House(
                    UUID.randomUUID().toString(),
                    houseDto.getAddress(),
                    houseDto.getDescription()
            );
        }

        return new House(
                houseDto.getId(),
                houseDto.getAddress(),
                houseDto.getDescription()
        );
    }
}
