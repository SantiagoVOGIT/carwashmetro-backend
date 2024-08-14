package io.santiagovogit.carwashmetro.domain.cell;

import io.santiagovogit.carwashmetro.domain.ValidationsUtils;
import io.santiagovogit.carwashmetro.domain.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.error.ErrorMessage;

import java.time.ZonedDateTime;

public class CellFactory {

    private CellFactory() {}

    public static Cell createCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus){

        validateCell(spaceNumber, vehicleType, cellStatus);

        return new Cell(
                new CellId(),
                spaceNumber,
                vehicleType,
                cellStatus,
                ZonedDateTime.now()
        );
    }

  private static void validateCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus){
      ValidationsUtils.validateNotNull(spaceNumber, ErrorMessage.SPACE_NUMBER_NULL.getMessage());
      ValidationsUtils.validateNotNull(vehicleType, ErrorMessage.VEHICLE_TYPE_NULL.getMessage());
      ValidationsUtils.validateNotNull(cellStatus, ErrorMessage.CELL_STATUS_NULL.getMessage());
  }

}
