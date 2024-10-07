package io.santiagovogit.carwashmetro.domain.cell;

import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;

import java.time.LocalDateTime;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;


public class CellFactory {

    private CellFactory() {}

    public static Cell createCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus status) {
        validateCell(spaceNumber, vehicleType, status);
        return new Cell(
                new CellId(),
                spaceNumber,
                vehicleType,
                status,
                LocalDateTime.now()
        );
    }

    private static void validateCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus status) {
        if (isNull(spaceNumber)) {
            throw new DomainException(ErrorMsg.SPACE_NUMBER_EMPTY.getMessage());
        }
        if (isNull(vehicleType)) {
            throw new DomainException(ErrorMsg.VEHICLE_TYPE_EMPTY.getMessage());
        }
        if (isNull(status)) {
            throw new DomainException(ErrorMsg.CELL_STATUS_EMPTY.getMessage());
        }
    }

}
