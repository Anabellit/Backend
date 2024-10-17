package at.technikum.springrestbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseSwapDto {
    private Long id;

    @NotNull(message = "House ID is required.")
    private Long houseId;  // Die ID des Hauses, auf das der HouseSwap verweist

    @NotBlank(message = "Message is required.")
    @Size(max = 500, message = "Message cannot be longer than 500 characters.")
    private String message;  // Nachricht des HouseSwaps

    @NotBlank(message = "Status is required.")
    @Size(max = 10, message = "Status cannot be longer than 10 characters.")
    private String status;  // Status als String (z.B. PENDING, ACCEPTED)
}
