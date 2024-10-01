package io.santiagovogit.carwashmetro.domain.cell;

import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;

import java.time.LocalDateTime;

public class Cell {

    private final CellId id;
    private final SpaceNumber spaceNumber;
    private final VehicleType vehicleType;
    private CellStatus status;
    private final LocalDateTime createdAt;

    public Cell(CellId id, SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus status, LocalDateTime createdAt) {
        this.id          = id;
        this.spaceNumber = spaceNumber;
        this.vehicleType = vehicleType;
        this.status      = status;
        this.createdAt   = createdAt;
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

    public CellStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Cell setStatus(CellStatus status) {
        this.status = status;
        return this;
    }

}

