/*
package at.technikum.springrestbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseSwapWithHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Beziehung zu House
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "house_id", nullable = false)
    @NotNull(message = "House is required.")
    private House house; // Referenziert das House-Objekt direkt

    @NotBlank(message = "Message is required.")
    @Size(max = 500, message = "Message cannot exceed 500 characters.")
    private String message;  // Die Nachricht des HouseSwaps

    @NotNull(message = "Status is required.")
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SwapStatus swapStatus = SwapStatus.PENDING;  // Status des HouseSwaps

    // Optional: SwapStatus als Enum für den Status
    public enum SwapStatus {
        PENDING, ACCEPTED, DECLINED, OPEN, CANCELLED
    }
}
*/

