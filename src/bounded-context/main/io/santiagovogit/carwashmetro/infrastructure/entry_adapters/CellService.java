
package io.santiagovogit.carwashmetro.infrastructure.entry_adapters;

import io.santiagovogit.carwashmetro.application.CellUseCase;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cells")
public class CellService {

    private final CellUseCase cellUseCase;

    public CellService(CellUseCase cellUseCase) {
        this.cellUseCase = cellUseCase;
    }

    @PostMapping
    public ResponseEntity<String> createCell(@RequestBody CreateCellRequest request) {
        cellUseCase.createCell(
                SpaceNumber.fromValue(request.getSpaceNumber()),
                VehicleType.fromValue(request.getVehicleType()),
                CellStatus.fromValue(request.getCellStatus())
        );
        return new ResponseEntity<>("Celda creada correctamente", HttpStatus.CREATED);
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
