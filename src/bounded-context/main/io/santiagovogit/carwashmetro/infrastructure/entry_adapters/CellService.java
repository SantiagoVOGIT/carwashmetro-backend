package io.santiagovogit.carwashmetro.infrastructure.entry_adapters;

import io.santiagovogit.carwashmetro.application.CellUseCase;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cells")
public class CellService {

    private final CellUseCase cellUseCase;

    public CellService(CellUseCase cellUseCase) {
        this.cellUseCase = cellUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createCell(@RequestBody CreateCellRequest request) {
        try {
            Cell cell = cellUseCase.createCell(
                    SpaceNumber.fromValue(request.getSpaceNumber()),
                    VehicleType.fromValue(request.getVehicleType()),
                    CellStatus.fromValue(request.getCellStatus())
            );
            return new ResponseEntity<>(cell, HttpStatus.CREATED);
        } catch (DomainException exc) {
            return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public static class CreateCellRequest {

        private String spaceNumber;
        private String vehicleType;
        private String cellStatus;

        public String getSpaceNumber() {
            return spaceNumber;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public String getCellStatus() {
            return cellStatus;
        }

    }

}