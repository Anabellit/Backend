package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import at.technikum.springrestbackend.service.HouseSwapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/swaps")
public class HouseSwapController {

    private final HouseSwapService houseSwapService;

    public HouseSwapController(HouseSwapService houseSwapService) {
        this.houseSwapService = houseSwapService;
    }


    //alle Anfragen
    @GetMapping()
    public List<HouseSwapDto> getAllRequests() {
        return houseSwapService.getAllRequests();
    }

    // Eine bestimmte Anfrage
    @GetMapping("/{id}")
    public HouseSwapDto getRequestById(@PathVariable Long id) {
        return houseSwapService.getRequestById(id);
    }

    // Eine Anfrage erstellen
    @PostMapping()
    public HouseSwapDto createRequest(@RequestBody HouseSwapDto requestDto) {
        return houseSwapService.createRequest(requestDto);
    }

    // Status von Request ändern: pending, cancelled and accept
    @PutMapping("/{id}")
    public HouseSwapDto updateRequestStatus(@PathVariable Long id, @RequestParam("status") String status) {
        return houseSwapService.updateRequestStatus(id, status);
    }

    //Request akzeptieren
    @PutMapping("/{id}/accept")
    public void acceptRequest(@PathVariable Long id) {
        houseSwapService.acceptRequest(id);
    }

    // Request reject
    @PutMapping("/{id}/reject")
    public void rejectRequest(@PathVariable Long id) {
        houseSwapService.rejectRequest(id);
    }

    // Optional delete? Oder gleich wie cancel
    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        houseSwapService.deleteRequest(id);
    }
}