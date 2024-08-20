package io.santiagovogit.carwashmetro.domain.cell;

import io.santiagovogit.carwashmetro.domain.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.error.ErrorMessage;

import java.util.Date;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotNull;


public class CellFactory {

    private CellFactory() {}

    public static Cell createCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus){

        validateCell(spaceNumber, vehicleType, cellStatus);

        return new Cell(
                new CellId(),
                spaceNumber,
                vehicleType,
                cellStatus,
                new Date()
        );
    }

  private static void validateCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus){
      validateNotNull(spaceNumber, ErrorMessage.SPACE_NUMBER_NULL.getMessage());
      validateNotNull(vehicleType, ErrorMessage.VEHICLE_TYPE_NULL.getMessage());
      validateNotNull(cellStatus, ErrorMessage.CELL_STATUS_NULL.getMessage());
  }

}
