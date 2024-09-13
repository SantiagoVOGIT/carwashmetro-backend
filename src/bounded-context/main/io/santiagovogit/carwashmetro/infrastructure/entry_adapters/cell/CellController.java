
package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.cell;

import io.santiagovogit.carwashmetro.application.CellUseCase;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import io.santiagovogit.carwashmetro.infrastructure.Response;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.cell.dto.CreateCellDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/cells")
public class CellController {

    private final CellUseCase cellUseCase;

    public CellController(CellUseCase cellUseCase) {
        this.cellUseCase = cellUseCase;
    }

    @PostMapping
    public ResponseEntity<Response> createCell(@RequestBody CreateCellDTO request) {
        cellUseCase.createCell(
                SpaceNumber.fromValue(request.getSpaceNumber()),
                VehicleType.fromValue(request.getVehicleType()),
                CellStatus.fromValue(request.getCellStatus())
        );
        Response response = Response.builder()
                .message("Celda creada correctamente")
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
