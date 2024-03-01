package at.technikum.springrestbackend.dto;

import jakarta.validation.constraints.NotBlank;

public class HouseSwapDto {
    @NotBlank
    private String id;
    @NotBlank
    private String user;
    @NotBlank
    private String swapper;
    @NotBlank
    private String house;
    @NotBlank
    private String swapHouse;

    public HouseSwapDto() {
    }

    public HouseSwapDto(String id, String user, String swapper, String house, String swapHouse) {
        this.id = id;
        this.user = user;
        this.swapper = swapper;
        this.house = house;
        this.swapHouse = swapHouse;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSwapper() {
        return swapper;
    }

    public void setSwapper(String swapper) {
        this.swapper = swapper;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getSwapHouse() {
        return swapHouse;
    }

    public void setSwapHouse(String swapHouse) {
        this.swapHouse = swapHouse;
    }
}
