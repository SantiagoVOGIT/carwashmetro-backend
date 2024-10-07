package io.santiagovogit.carwashmetro.application.cell;

import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.DomainException;
import org.springframework.stereotype.Service;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;


@Service
public class CellService {

    private final CellRepository cellRepository;

    public CellService(CellRepository cellRepository) {
        this.cellRepository = cellRepository;
    }

    public void ensureCellIdPresent(CellId cellId) {
        if (isEmpty(cellId.getValue())) {
            throw new DomainException(ErrorMsg.CELL_ID_EMPTY.getMessage());
        }
    }

    public void ensureCellExists(CellId cellId) {
        ensureCellIdPresent(cellId);
        if (!cellRepository.existsById(cellId)) {
            throw new DomainException(ErrorMsg.CELL_NOT_FOUND.getMessage());
        }
    }

}
