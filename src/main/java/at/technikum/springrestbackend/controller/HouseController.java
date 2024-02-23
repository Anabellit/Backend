package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.mapper.HouseMapper;
import at.technikum.springrestbackend.model.House;
import at.technikum.springrestbackend.service.HouseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/houses")
public class HouseController {

    private final HouseService houseService;
    private HouseMapper houseMapper;

    public HouseController(HouseService houseService, HouseMapper houseMapper) {
        this.houseService = houseService;
        this.houseMapper = houseMapper;
    }

    //Alle verfügbaren Häuser:
    @GetMapping
    public List<HouseDto> getAllHouses() {
        return houseService.getAllHouses().stream()
                .map(houseMapper::toDto)
                .collect(Collectors.toList());
    }

    //Bestimmtes Haus:
    @GetMapping("/{id}")
    public HouseDto getHouseById(@PathVariable String id) {

        return houseMapper.toDto(houseService.getHouseById(id));
    }


    // Haus wird erstellt
    @PostMapping
    public HouseDto createHouse(@RequestBody HouseDto houseDto) {

        House house = houseMapper.toEntity(houseDto);
        house = houseService.createHouse(house);

        return houseMapper.toDto(house);
    }

    // Gleiche nur mit updaten eines Hause
  /*  @PutMapping("/{id}")
    public HouseDto updateHouse(@PathVariable Long id, @RequestBody HouseDto houseDto) {
        return houseService.updateHouse(id, houseDto);
    }*/

    @PutMapping("/{id}")
    public HouseDto update(@PathVariable String id) {
        return new HouseDto("123", "Gasse 1", "schoene Wohnung");
    }

    // Löschen. void-no response
    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable String id) {
        houseService.deleteHouse(id);
    }
}
