/*
package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.HouseSwapWithHouseDto;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.model.HouseSwapWithHouse;
import org.springframework.stereotype.Component;

@Component
public class HouseSwapWithHouseMapper {

    // Methode zum Mappen von Entity zu DTO
    public HouseSwapWithHouseDto toDtoFromEntities(House house, HouseSwapWithHouse houseSwap) {
        return new HouseSwapWithHouseDto(
                houseSwap.getId(),
                house.getId(),  // House ID
                house.getTypeOfHouse(),  // House Type of House
                house.getCountry(),  // House Country
                houseSwap.getMessage(),  // Swap Message
                houseSwap.getSwapStatus()  // Swap Status
        );
    }

    // Methode zum Mappen von DTO zu Entity
    public HouseSwapWithHouse toEntity(HouseSwapWithHouseDto dto, House house) {
        HouseSwapWithHouse houseSwap = new HouseSwapWithHouse();
        houseSwap.setId(dto.getId());  // Setze die ID, falls vorhanden
        houseSwap.setHouse(house);  // Weise das House-Objekt zu
        houseSwap.setMessage(dto.getMessage());  // Setze die Message
        houseSwap.setSwapStatus(dto.getSwapStatus());  // Setze den Status
        return houseSwap;
    }

    // Alternative Methode zum Erstellen einer neuen Entity direkt aus DTO und House-Objekt
    public HouseSwapWithHouse toEntity(House house, HouseSwapWithHouse houseSwap) {
        houseSwap.setHouse(house);  // Weise das House-Objekt zu
        return houseSwap;
    }
}
*/
