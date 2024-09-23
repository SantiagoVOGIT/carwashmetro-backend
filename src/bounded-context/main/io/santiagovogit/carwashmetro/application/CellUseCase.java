package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.CellFactory;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CellUseCase {

    private final CellRepository cellRepository;

    public CellUseCase(CellRepository cellRepository){
        this.cellRepository = cellRepository;
    }

    public void createCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus){
        validateUniqueCell(spaceNumber);
        Cell cell = CellFactory.createCell(
                spaceNumber,
                vehicleType,
                cellStatus
        );
        cellRepository.save(cell);
    }

    public List<Cell> getAllCells(){
        List<Cell> cells = cellRepository.findAll();
        if (cells.isEmpty()) {
            throw new DomainException(ErrorType.CELLS_NOT_FOUND.getMessage());
        }
        return cells;
    }

    public Cell getCellById(CellId cellId){
        return cellRepository.findById(cellId)
                .orElseThrow(() -> new DomainException(ErrorType.CELL_NOT_FOUND.getMessage()));
    }

    private void validateUniqueCell(SpaceNumber spaceNumber){
        Optional<Cell> cell = cellRepository.findBySpaceNumber(spaceNumber);
        if (cell.isPresent()) {
            throw new DomainException(ErrorType.CELL_ALREADY_EXIST.getMessage());
        }
    }

}

