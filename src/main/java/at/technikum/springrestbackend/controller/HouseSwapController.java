package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import at.technikum.springrestbackend.service.HouseSwapService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houseswap")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63343")
public class HouseSwapController {

    private final HouseSwapService houseSwapService;

    // GET-Endpunkt, um alle HouseSwaps zusammen mit den House-Daten abzurufen
    @GetMapping
    public ResponseEntity<List<HouseSwapDto>> getAllHouseSwapsWithDetails() {
        List<HouseSwapDto> swaps = houseSwapService.getAllHouseSwapsWithDetails();
        // Rückgabe mit 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(swaps);
    }

    // GET-Endpunkt, um einen bestimmten HouseSwap mit den House-Daten nach ID abzurufen
    @GetMapping("/{id}")
    public ResponseEntity<HouseSwapDto> getHouseSwapWithDetailsById(@PathVariable Long id) {
        HouseSwapDto houseSwap = houseSwapService.getHouseSwapWithDetailsById(id);
        // Rückgabe mit 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(houseSwap);
    }

    // POST-Endpunkt, um einen neuen HouseSwap zu erstellen
    @PostMapping
    public ResponseEntity<HouseSwapDto> createHouseSwap(@RequestBody
                                                        @Valid HouseSwapDto houseSwapDto) {
        HouseSwapDto createdHouseSwap = houseSwapService.createHouseSwap(houseSwapDto);
        // Rückgabe mit 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHouseSwap);
    }

    // PUT-Endpunkt, um einen bestehenden HouseSwap zu aktualisieren
    @PutMapping("/{id}")
    public ResponseEntity<HouseSwapDto> updateHouseSwap(@PathVariable Long id,
                                                        @RequestBody
                                                        @Valid HouseSwapDto houseSwapDto) {
        HouseSwapDto updatedHouseSwap = houseSwapService.updateHouseSwap(id, houseSwapDto);
        // Rückgabe mit 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(updatedHouseSwap);
    }

    // DELETE-Endpunkt, um einen HouseSwap zu löschen
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouseSwap(@PathVariable Long id) {
        houseSwapService.deleteHouseSwap(id);
        // Rückgabe mit 204 No Content
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
