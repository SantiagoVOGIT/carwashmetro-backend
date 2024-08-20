package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.CellFactory;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;

public class CellUseCase {

    CellRepository cellRepository;

    public CellUseCase(CellRepository cellRepository){
        this.cellRepository = cellRepository;
    }

    public Cell createCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus){
        Cell cell = CellFactory.createCell(
                spaceNumber,
                vehicleType,
                cellStatus
        );
        cellRepository.save(cell);
        return cell;
    }

}
