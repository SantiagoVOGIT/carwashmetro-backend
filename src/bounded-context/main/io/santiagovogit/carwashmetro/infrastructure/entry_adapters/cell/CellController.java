package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.cell;

import io.santiagovogit.carwashmetro.application.CellUseCase;
import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.common.InfoType;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import io.santiagovogit.carwashmetro.infrastructure.Response;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.cell.dto.CellDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.cell.dto.CreateCellDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.common.DTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cells")
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
                CellStatus.fromValue(request.getStatus())
        );
        Response response = DTOMapper.toDTO(InfoType.SUCCESS_CREATED_CELL.getMessage());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{cellId}")
    public ResponseEntity<CellDTO> getCellById(@PathVariable UUID cellId) {
        Cell cell = cellUseCase.getCellById(new CellId(cellId));
        CellDTO response = DTOMapper.toDTO(cell);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CellDTO>> getAllCells() {
        List<Cell> cells = cellUseCase.getAllCells();
        List<CellDTO> response = cells.stream()
                .map(DTOMapper::toDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

}