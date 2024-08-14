package io.santiagovogit.carwashmetro.domain.cell;

import io.santiagovogit.carwashmetro.domain.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;

import java.time.ZonedDateTime;

public class Cell {

    private final CellId id;

    private final SpaceNumber spaceNumber;

    private final VehicleType vehicleType;

    private final CellStatus cellStatus;

    private final ZonedDateTime createdAt;

    public Cell(CellId id, SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus, ZonedDateTime createdAt) {
        this.id = id;
        this.spaceNumber = spaceNumber;
        this.vehicleType = vehicleType;
        this.cellStatus = cellStatus;
        this.createdAt = createdAt;
    }

    public CellId getId() {
        return id;
    }

    public SpaceNumber getSpaceNumber() {
        return spaceNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

}
