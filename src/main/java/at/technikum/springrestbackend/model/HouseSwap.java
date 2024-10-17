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
    private Long id;  // Die ID des HouseSwaps

    @ManyToOne(fetch = FetchType.LAZY)  // Beziehung zu House
    @JoinColumn(name = "house_id", nullable = false)
    @NotNull(message = "House is required.")  // Validierung: House darf nicht null sein
    private House house;

    @Column(nullable = false, length = 500)
    @NotBlank(message = "Message is required.")
    @Size(max = 500, message = "Message cannot be longer than 500 characters.")
    private String message;  // Nachricht des HouseSwaps

    @Column(nullable = false, length = 10)
    @NotBlank(message = "Status is required.")
    @Size(max = 10, message = "Status cannot be longer than 10 characters.")
    private String status = "pending";  // Standardstatus: pending

    // Konstruktor zur einfacheren Verwendung
    public HouseSwap(Long id, House house, String message, String status) {
        this.id = id;
        this.house = house;
        this.message = message;
        this.status = status;
    }
}
