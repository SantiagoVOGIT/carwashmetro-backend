package io.santiagovogit.carwashmetro.application.common;

import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import org.springframework.stereotype.Service;

@Service
public class CellService {

    CellRepository cellRepository;

    public CellService(CellRepository cellRepository) {
        this.cellRepository = cellRepository;
    }

    public void ensureCellExists(CellId cellId) {
        if (!cellRepository.existsById(cellId)) {
            throw new DomainException(ErrorType.CELL_NOT_FOUND.getMessage());
        }
    }

}
