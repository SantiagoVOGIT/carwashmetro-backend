package io.santiagovogit.carwashmetro.domain.cell;

import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;

import java.util.Date;

public class Cell {

    private final CellId id;

    private final SpaceNumber spaceNumber;

    private final VehicleType vehicleType;

    private final CellStatus cellStatus;

    private final Date createdAt;

    public Cell(CellId id, SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus, Date createdAt) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "id=" + id +
                ", spaceNumber=" + spaceNumber.getValue() +
                ", vehicleType=" + vehicleType.getValue() +
                ", cellStatus=" + cellStatus.getValue() +
                ", createdAt=" + createdAt +
                '}';
    }

}
