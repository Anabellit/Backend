package at.technikum.springrestbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HouseDto {

    private Long id;

    @NotBlank(message = "Type of house is required")
    private String typeOfHouse;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Title is required")
    @Size(max = 50, message = "Title must not exceed 50 characters")
    private String title;

    @NotBlank(message = "Subtitle is required")
    @Size(max = 50, message = "Subtitle must not exceed 50 characters")
    private String subtitle;

    @NotBlank(message = "Short description is required")
    @Size(max = 50, message = "Short description must not exceed 50 characters")
    private String shortDescription;

    @NotBlank(message = "Long description is required")
    @Size(max = 1000, message = "Long description must not exceed 1000 characters")
    private String longDescription;


    private boolean hasWifi;


    private boolean hasKitchen;


    private boolean hasStreaming;


    private boolean hasHomeOffice;


    private boolean nearSupermarkets;


    private boolean hasSelfCheckin;

    @NotNull(message = "User ID is required")
    private Long userId;
}

