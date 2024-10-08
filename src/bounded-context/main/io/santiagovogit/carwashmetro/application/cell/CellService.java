package io.santiagovogit.carwashmetro.application.cell;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import org.springframework.stereotype.Service;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;


@Service
public class CellService {

    private final CellRepository cellRepository;

    public CellService(CellRepository cellRepository) {
        this.cellRepository = cellRepository;
    }

    public Cell getCellByIdOrThrow(CellId cellId) {
        return cellRepository.findById(cellId)
                .orElseThrow(() -> new DomainException(ErrorMsg.CELL_NOT_FOUND.getMessage()));
    }

    public void ensureCellExists(CellId cellId) {
        ensureCellIdPresent(cellId);
        if (!cellRepository.existsById(cellId)) {
            throw new DomainException(ErrorMsg.CELL_NOT_FOUND.getMessage());
        }
    }

    public void updateCellStatus(CellId cellId, CellStatus status) {
        Cell cell = getCellByIdOrThrow(cellId);
        cell.setStatus(status);
        cellRepository.save(cell);
    }

    private void ensureCellIdPresent(CellId cellId) {
        if (isEmpty(cellId.getValue())) {
            throw new DomainException(ErrorMsg.CELL_ID_EMPTY.getMessage());
        }
    }

}
