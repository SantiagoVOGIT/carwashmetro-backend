package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.VehicleFactory;
import io.santiagovogit.carwashmetro.domain.vehicle.ports.VehicleRepository;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleUseCase {

    private final VehicleRepository vehicleRepository;

    public VehicleUseCase(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void createVehicle(UserId userId, String licensePlate, String model, VehicleType vehicleType) {
        Vehicle vehicle = VehicleFactory.createVehicle(userId, licensePlate, model, vehicleType);
        validateUniqueVehicle(licensePlate);
        vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(VehicleId vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new DomainException(ErrorType.VEHICLE_NOT_FOUND.getMessage()));
    }

    public Vehicle getVehicleByUserId(UserId userId) {
        return vehicleRepository.findByUserId(userId)
                .orElseThrow(() -> new DomainException(ErrorType.USER_NOT_FOUND.getMessage()));
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        if (vehicles.isEmpty()) {
            throw new DomainException(ErrorType.VEHICLES_NOT_FOUND.getMessage());
        }
        return vehicles;
    }

    public List<Vehicle> getAllVehiclesByUserId(UserId userId) {
        List<Vehicle> vehicles = vehicleRepository.findAllByUserId(userId);
        if (vehicles.isEmpty()) {
            throw new DomainException(ErrorType.VEHICLES_NOT_FOUND.getMessage());
        }
        return vehicles;
    }

    public void validateUniqueVehicle(String licensePlate) {
        Optional<Vehicle> vehicle = vehicleRepository.findByLicensePlate(licensePlate);
        if (vehicle.isPresent()) {
            throw new DomainException(ErrorType.VEHICLE_ALREADY_EXISTS.getMessage());
        }
    }

}
