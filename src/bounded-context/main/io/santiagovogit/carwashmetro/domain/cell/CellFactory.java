package io.santiagovogit.carwashmetro.domain.cell;

import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;

import java.util.Date;

public class CellFactory {

    private CellFactory() {}

    public static Cell createCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus){
        return new Cell(
                new CellId(),
                spaceNumber,
                vehicleType,
                cellStatus,
                new Date()
        );
    }

}
