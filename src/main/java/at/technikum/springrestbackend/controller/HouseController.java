package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.HouseDto;
import at.technikum.springrestbackend.service.HouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63343")
@RestController
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    // GET - Abrufen aller Häuser
    @GetMapping
    public ResponseEntity<List<HouseDto>> getAllHouses() {
        List<HouseDto> houses = houseService.getAllHouses();
        // Rückgabe mit 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(houses);
    }

    // GET - Abrufen eines Hauses anhand der ID
    @GetMapping("/{id}")
    public ResponseEntity<HouseDto> getHouseById(@PathVariable Long id) {
        HouseDto house = houseService.getHouseById(id);
        // Rückgabe mit 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(house);
    }

    // POST - Erstellen eines neuen Hauses
    @PostMapping("/register")
    public ResponseEntity<HouseDto> createHouse(@RequestBody @Valid HouseDto houseDto) {
        HouseDto createdHouse = houseService.createHouse(houseDto);
        // Rückgabe mit 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHouse);
    }

    // PUT - Aktualisieren eines Hauses anhand der ID
    @PutMapping("/{id}")
    public ResponseEntity<HouseDto> updateHouse(@PathVariable Long id,
                                                @RequestBody
                                                @Valid HouseDto houseDto) {
        HouseDto updatedHouse = houseService.updateHouse(id, houseDto);
        // Rückgabe mit 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(updatedHouse);
    }

    // GET - Abrufen eines Hauses anhand der User-ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<HouseDto> getHouseByUserId(@PathVariable Long userId) {
        HouseDto houseDto = houseService.getHouseByUserId(userId);

        if (houseDto != null) {
            return ResponseEntity.ok(houseDto);  // HTTP 200 OK, wenn das Haus gefunden wurde
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);   // HTTP 404 Not Found, wenn kein Haus gefunden wurde
        }
    }

    // PUT - Aktualisieren eines Hauses basierend auf der User-ID
    @PutMapping("/user/{userId}")
    public ResponseEntity<HouseDto> updateHouseByUserId(@PathVariable Long userId,
                                                        @RequestBody @Valid HouseDto houseDto) {
        HouseDto updatedHouse = houseService.updateHouseByUserId(userId, houseDto);

        if (updatedHouse != null) {
            return ResponseEntity.ok(updatedHouse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
