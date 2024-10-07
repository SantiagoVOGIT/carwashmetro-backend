package io.santiagovogit.carwashmetro.application.vehicle;

import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.vehicle.ports.VehicleRepository;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import org.springframework.stereotype.Service;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;


@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void ensureVehicleIdPresent(VehicleId vehicleId) {
        if (isEmpty(vehicleId.getValue())) {
            throw new DomainException(ErrorMsg.VEHICLE_ID_EMPTY.getMessage());
        }
    }

    public void ensureVehicleExists(VehicleId vehicleId) {
        ensureVehicleIdPresent(vehicleId);
        if (!vehicleRepository.existsById(vehicleId)) {
            throw new DomainException(ErrorMsg.VEHICLE_NOT_FOUND.getMessage());
        }
    }

}
