/*
package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.HouseSwapWithHouseDto;
import at.technikum.springrestbackend.service.HouseSwapService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houseswaps")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63343")  // Erlaubt CORS-Anfragen von deinem Frontend
public class HouseSwapWithHouseController {

    private final HouseSwapService houseSwapService;

    // GET - Alle HouseSwaps mit Hausdetails abrufen
    @GetMapping
    public List<HouseSwapWithHouseDto> getAllHouseSwaps() {
        return houseSwapService.getAllHouseSwapsWithDetails();
    }

    // GET - Einen einzelnen HouseSwap mit Hausdetails anhand der ID abrufen
    @GetMapping("/{id}")
    public HouseSwapWithHouseDto getHouseSwapById(@PathVariable Long id) {
        return houseSwapService.getHouseSwapWithDetailsById(id);
    }

    // POST - Einen neuen HouseSwap erstellen
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HouseSwapWithHouseDto createHouseSwap(@RequestBody
                                                 @Valid HouseSwapWithHouseDto houseSwapDto) {
        return houseSwapService.createHouseSwap(houseSwapDto);
    }

    // PUT - Einen vorhandenen HouseSwap aktualisieren
    @PutMapping("/{id}")
    public HouseSwapWithHouseDto updateHouseSwap(@PathVariable Long id,
                                                 @RequestBody
                                                 @Valid HouseSwapWithHouseDto houseSwapDto) {
        return houseSwapService.updateHouseSwap(id, houseSwapDto);
    }

    // DELETE - Einen HouseSwap löschen
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHouseSwap(@PathVariable Long id) {
        houseSwapService.deleteHouseSwap(id);
    }
}
*/

