package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.service.HouseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/houses")
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    //Alle verfügbaren Häuser:
    @GetMapping
    public List<HouseDto> getAllHouses() {
        return houseService.getAllHouses();
    }

    //Bestimmtes Haus:
    @GetMapping("/{id}")
    public HouseDto getHouseById(@PathVariable Long id) {
        return houseService.getHouseById(id);
    }


    // Haus wird erstellt
    @PostMapping
    public HouseDto createHouse(@RequestBody HouseDto houseDto) {
        return houseService.createHouse(houseDto);
    }

    // Gleiche nur mit updaten eines Hause
    @PutMapping("/{id}")
    public HouseDto updateHouse(@PathVariable Long id, @RequestBody HouseDto houseDto) {
        return houseService.updateHouse(id, houseDto);
    }

    // Löschen. void-no response
    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
    }
}
