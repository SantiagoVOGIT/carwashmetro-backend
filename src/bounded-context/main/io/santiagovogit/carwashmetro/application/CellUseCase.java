package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.CellFactory;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import org.springframework.stereotype.Service;

@Service
public class CellUseCase {

    private final CellRepository cellRepository;

    public CellUseCase(CellRepository cellRepository){
        this.cellRepository = cellRepository;
    }

    public Cell createCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus){
        validateCellDoesNotExist(spaceNumber);
        Cell cell = CellFactory.createCell(
                spaceNumber,
                vehicleType,
                cellStatus
        );
        cellRepository.save(cell);
        return cell;
    }

    private void validateCellDoesNotExist(SpaceNumber spaceNumber){
        Cell cell = cellRepository.findBySpaceNumber(spaceNumber);
        if (cell != null) {
            throw new DomainException(ErrorType.CELL_ALREADY_EXIST.getMessage());
        }
    }

}