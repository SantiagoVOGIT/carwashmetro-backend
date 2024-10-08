package io.santiagovogit.carwashmetro.application.cell;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.CellFactory;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CellUseCase {

    private final CellRepository cellRepository;
    private final CellService cellService;

    public CellUseCase(CellRepository cellRepository, CellService cellService){
        this.cellRepository = cellRepository;
        this.cellService    = cellService;
    }

    public void createCell(SpaceNumber spaceNumber, VehicleType vehicleType, CellStatus cellStatus){
        Cell cell = CellFactory.createCell(spaceNumber, vehicleType, cellStatus);
        ensureUniqueCell(spaceNumber);
        cellRepository.save(cell);
    }

    public Cell getCellById(CellId cellId){
        return cellService.getCellByIdOrThrow(cellId);
    }

    public List<Cell> getAllCells(){
        List<Cell> cells = cellRepository.findAll();
        if (cells.isEmpty()) {
            throw new DomainException(ErrorMsg.CELLS_NOT_FOUND.getMessage());
        }
        return cells;
    }

    public void ensureUniqueCell(SpaceNumber spaceNumber){
        Optional<Cell> cell = cellRepository.findBySpaceNumber(spaceNumber);
        if (cell.isPresent()) {
            throw new DomainException(ErrorMsg.CELL_ALREADY_EXIST.getMessage());
        }
    }

}

