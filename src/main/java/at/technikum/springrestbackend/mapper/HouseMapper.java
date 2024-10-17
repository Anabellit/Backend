package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.model.House;
import org.springframework.stereotype.Component;

@Component
public class HouseMapper {

    public HouseDto toDto(House house) {
        HouseDto dto = new HouseDto();
        dto.setId(house.getId());
        dto.setTypeOfHouse(house.getTypeOfHouse());
        dto.setCountry(house.getCountry());
        dto.setTitle(house.getTitle());
        dto.setSubtitle(house.getSubtitle());
        dto.setShortDescription(house.getShortDescription());
        dto.setLongDescription(house.getLongDescription());
        dto.setHasWifi(house.isHasWifi());
        dto.setHasKitchen(house.isHasKitchen());
        dto.setHasStreaming(house.isHasStreaming());
        dto.setHasHomeOffice(house.isHasHomeOffice());
        dto.setNearSupermarkets(house.isNearSupermarkets());
        dto.setHasSelfCheckin(house.isHasSelfCheckin());
        return dto;
    }

    public House toEntity(HouseDto dto) {
        House house = new House();
        house.setTypeOfHouse(dto.getTypeOfHouse());
        house.setCountry(dto.getCountry());
        house.setTitle(dto.getTitle());
        house.setSubtitle(dto.getSubtitle());
        house.setShortDescription(dto.getShortDescription());
        house.setLongDescription(dto.getLongDescription());
        house.setHasWifi(dto.isHasWifi());
        house.setHasKitchen(dto.isHasKitchen());
        house.setHasStreaming(dto.isHasStreaming());
        house.setHasHomeOffice(dto.isHasHomeOffice());
        house.setNearSupermarkets(dto.isNearSupermarkets());
        house.setHasSelfCheckin(dto.isHasSelfCheckin());
        return house;
    }
}
