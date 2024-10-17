package at.technikum.springrestbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "houseswaps")
@Getter
@Setter
@NoArgsConstructor
public class HouseSwap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Die ID des HouseSwaps

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    @NotNull(message = "House is required") // Validierung: Das zugehörige Haus darf nicht null sein
    private House house; // Verweis auf das Haus

    @Column(nullable = false, length = 500)
    @NotBlank(message = "Message is required") // Validierung: Nachricht darf nicht leer sein
    @Size(max = 500, message = "Message cannot be longer than 500 characters")
    private String message; // Nachricht des HouseSwaps


    @NotBlank(message = "Status is required") // Validierung: Status darf nicht leer sein
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HouseSwapWithHouse.SwapStatus status = HouseSwapWithHouse.SwapStatus.PENDING;  // Enum mit Standardwert PENDING

    public HouseSwap(HouseSwapWithHouse.SwapStatus status, String message, House house, Long id) {
        this.status = status;
        this.message = message;
        this.house = house;
        this.id = id;
    }
}
