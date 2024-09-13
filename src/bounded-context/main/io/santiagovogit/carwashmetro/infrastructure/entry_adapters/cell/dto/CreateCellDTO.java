package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.cell.dto;

public class CreateCellDTO {

    private String spaceNumber;
    private String vehicleType;
    private String cellStatus;

    public String getSpaceNumber() {
        return spaceNumber;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public String getCellStatus() {
        return cellStatus;
    }

}