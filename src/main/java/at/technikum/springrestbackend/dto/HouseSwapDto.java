package at.technikum.springrestbackend.dto;

import at.technikum.springrestbackend.model.HouseSwapWithHouse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HouseSwapDto {

    private Long id; // Die ID des HouseSwaps (automatisch generiert)

    @NotNull(message = "House ID is required") // House ID darf nicht null sein
    private Long houseId; // Foreign Key: Verweis auf das House

    @NotBlank(message = "Message is required")
    @Size(max = 500, message = "Message cannot be longer than 500 characters")
    private String message; // Nachricht des HouseSwaps

    @NotNull(message = "Status is required.")
    private HouseSwapWithHouse.SwapStatus swapStatus = HouseSwapWithHouse.SwapStatus.PENDING;

}
