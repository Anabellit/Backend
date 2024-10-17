package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import at.technikum.springrestbackend.service.HouseSwapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houseswap")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63343")  // Erlaubt CORS-Anfragen von deinem Frontend
public class HouseSwapController {

    private final HouseSwapService houseSwapService;

    // GET-Endpunkt, um alle HouseSwaps zusammen mit den House-Daten abzurufen
    @GetMapping
    public List<HouseSwapDto> getAllHouseSwapsWithDetails() {
        return houseSwapService.getAllHouseSwapsWithDetails();
    }

    // GET-Endpunkt, um einen bestimmten HouseSwap mit den House-Daten nach ID abzurufen
    @GetMapping("/{id}")
    public HouseSwapDto getHouseSwapWithDetailsById(@PathVariable Long id) {
        return houseSwapService.getHouseSwapWithDetailsById(id);
    }

    // POST-Endpunkt, um einen neuen HouseSwap zu erstellen
    @PostMapping
    public HouseSwapDto createHouseSwap(@RequestBody HouseSwapDto houseSwapDto) {
        return houseSwapService.createHouseSwap(houseSwapDto);
    }

    // PUT-Endpunkt, um einen bestehenden HouseSwap zu aktualisieren
    @PutMapping("/{id}")
    public HouseSwapDto updateHouseSwap(@PathVariable Long id,
                                        @RequestBody HouseSwapDto houseSwapDto) {
        return houseSwapService.updateHouseSwap(id, houseSwapDto);
    }

    // DELETE-Endpunkt, um einen HouseSwap zu löschen
    @DeleteMapping("/{id}")
    public void deleteHouseSwap(@PathVariable Long id) {
        houseSwapService.deleteHouseSwap(id);
    }
}
