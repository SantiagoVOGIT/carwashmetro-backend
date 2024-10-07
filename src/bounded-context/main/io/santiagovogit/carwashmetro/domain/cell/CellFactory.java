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
        validateCell(vehicleType);
        return new Cell(
                new CellId(),
                spaceNumber,
                vehicleType,
                status,
                LocalDateTime.now()
        );
    }

    private static void validateCell(VehicleType vehicleType) {
        if (isNull(vehicleType)) {
            throw new DomainException(ErrorMsg.VEHICLE_TYPE_EMPTY.getMessage());
        }
    }

}
