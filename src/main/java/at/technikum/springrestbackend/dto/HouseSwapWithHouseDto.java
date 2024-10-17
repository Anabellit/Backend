/*
package at.technikum.springrestbackend.dto;

import at.technikum.springrestbackend.model.HouseSwapWithHouse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseSwapWithHouseDto {

    private Long id;  // ID des HouseSwaps

    @NotNull(message = "House ID is required.")
    private Long houseId;  // Referenziert die ID des Hauses

    private String houseTypeOfHouse;  // Typ des Hauses (vom Hausobjekt übernommen)

    private String houseCountry;  // Land des Hauses (vom Hausobjekt übernommen)

    @NotBlank(message = "Message is required.")
    @Size(max = 500, message = "Message cannot exceed 500 characters.")
    private String message;  // Nachricht des HouseSwaps

    @NotNull(message = "Status is required.")
    private HouseSwapWithHouse.SwapStatus swapStatus = HouseSwapWithHouse.SwapStatus.PENDING;
}*/
