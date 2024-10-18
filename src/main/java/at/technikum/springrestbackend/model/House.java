package at.technikum.springrestbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "houses_")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String typeOfHouse;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 50)
    private String subtitle;

    @Column(nullable = false, length = 50)
    private String shortDescription;

    @Column(nullable = false, length = 1000)
    private String longDescription;

    @Column(nullable = true)
    private boolean hasWifi;

    @Column(nullable = true)
    private boolean hasKitchen;

    @Column(nullable = true)
    private boolean hasStreaming;

    @Column(nullable = true)
    private boolean hasHomeOffice;

    @Column(nullable = true)
    private boolean nearSupermarkets;

    @Column(nullable = true)
    private boolean hasSelfCheckin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
