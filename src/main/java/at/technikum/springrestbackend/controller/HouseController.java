package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.service.HouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63343")
@RestController
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping
    public List<HouseDto> getAllHouses() {
        return houseService.getAllHouses();
    }

    @GetMapping("/{id}")
    public HouseDto getHouseById(@PathVariable Long id) {
        return houseService.getHouseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HouseDto createHouse(@RequestBody @Valid HouseDto houseDto) {
        return houseService.createHouse(houseDto);
    }

    @PutMapping("/{id}")
    public HouseDto updateHouse(
            @PathVariable Long id,
            @RequestBody @Valid HouseDto houseDto) {
        return houseService.updateHouse(id, houseDto);
    }
}

