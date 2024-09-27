package io.santiagovogit.carwashmetro.application.common;

import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.vehicle.ports.VehicleRepository;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void ensureVehicleExists(VehicleId vehicleId) {
        if (!vehicleRepository.existsById(vehicleId)) {
            throw new DomainException(ErrorType.VEHICLE_NOT_FOUND.getMessage());
        }
    }

}
