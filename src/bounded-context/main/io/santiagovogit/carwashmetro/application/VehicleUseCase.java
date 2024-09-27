package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.application.common.UserService;
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
    private final UserService userService;

    public VehicleUseCase(VehicleRepository vehicleRepository, UserService userService) {
        this.vehicleRepository = vehicleRepository;
        this.userService       = userService;
    }

    public void createVehicle(UserId userId, String licensePlate, String model, VehicleType vehicleType) {
        userService.ensureUserExists(userId);
        Vehicle vehicle = VehicleFactory.createVehicle(userId, licensePlate, model, vehicleType);
        ensureUniqueVehicle(licensePlate);
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
        userService.ensureUserExists(userId);
        List<Vehicle> vehicles = vehicleRepository.findAllByUserId(userId);
        if (vehicles.isEmpty()) {
            throw new DomainException(ErrorType.VEHICLES_NOT_FOUND.getMessage());
        }
        return vehicles;
    }

    public void ensureUniqueVehicle(String licensePlate) {
        Optional<Vehicle> vehicle = vehicleRepository.findByLicensePlate(licensePlate);
        if (vehicle.isPresent()) {
            throw new DomainException(ErrorType.VEHICLE_ALREADY_EXISTS.getMessage());
        }
    }

}
