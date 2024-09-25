package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.vehicle;

import io.santiagovogit.carwashmetro.application.VehicleUseCase;
import io.santiagovogit.carwashmetro.domain.common.InfoType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import io.santiagovogit.carwashmetro.infrastructure.Response;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.common.ResponseMapper;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.vehicle.dto.CreateVehicleDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.vehicle.dto.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/vehicles")
public class VehicleController {

    private final VehicleUseCase vehicleUseCase;

    @Autowired
    public VehicleController(VehicleUseCase vehicleUseCase) {
        this.vehicleUseCase = vehicleUseCase;
    }

    @PostMapping
    public ResponseEntity<Response> createVehicle(@RequestBody CreateVehicleDTO request) {
        vehicleUseCase.createVehicle(
                new UserId(request.getUserId()),
                request.getLicensePlate(),
                request.getModel(),
                VehicleType.fromValue(request.getVehicleType())
        );
        Response response = ResponseMapper.toResponse(InfoType.SUCCESS_CREATED_VEHICLE.getMessage());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable UUID vehicleId) {
        Vehicle vehicle = vehicleUseCase.getVehicleById(new VehicleId(vehicleId));
        VehicleDTO response = ResponseMapper.toResponse(vehicle);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<VehicleDTO> getVehicleByUserId(@PathVariable UUID userId) {
        Vehicle vehicle = vehicleUseCase.getVehicleByUserId(new UserId(userId));
        VehicleDTO response = ResponseMapper.toResponse(vehicle);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleUseCase.getAllVehicles();
        List<VehicleDTO> response = vehicles.stream()
                .map(ResponseMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}/vehicles")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesByUserId(@PathVariable UUID userId) {
        List<Vehicle> vehicles = vehicleUseCase.getAllVehiclesByUserId(new UserId(userId));
        List<VehicleDTO> response = vehicles.stream()
                .map(ResponseMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

}