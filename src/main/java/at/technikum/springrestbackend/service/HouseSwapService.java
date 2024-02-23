package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.HouseSwapDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseSwapService {

    private final List<HouseSwapDto> requests = new ArrayList<>();

    public List<HouseSwapDto> getAllRequests() {
        return requests;
    }

    public HouseSwapDto getRequestById(Long id) {
        // Logik, um die Anfrage mit der angegebenen ID zu finden
        return null; // Dummy-Rückgabewert
    }

    public HouseSwapDto createRequest(HouseSwapDto requestDto) {
        // Logik, um eine neue Anfrage zu erstellen und zur Liste hinzuzufügen
        return requestDto; // Dummy-Rückgabewert
    }

    public HouseSwapDto updateRequestStatus(Long id, String status) {
        // Logik, um den Status einer vorhandenen Anfrage zu aktualisieren
        return null; // Dummy-Rückgabewert
    }

    public void acceptRequest(Long id) {
        // Logik, um eine Anfrage zu akzeptieren
    }

    public void rejectRequest(Long id) {
        // Logik, um eine Anfrage abzulehnen
    }

    public void deleteRequest(Long id) {
        // Logik, um eine Anfrage zu löschen
    }
}
