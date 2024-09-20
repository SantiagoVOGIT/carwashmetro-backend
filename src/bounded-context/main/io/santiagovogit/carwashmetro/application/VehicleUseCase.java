package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.VehicleFactory;
import io.santiagovogit.carwashmetro.domain.vehicle.ports.VehicleRepository;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;

import java.util.List;

public class VehicleUseCase {

    private final VehicleRepository vehicleRepository;

    public VehicleUseCase(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void createVehicle(UserId userId, String licensePlate, String model, VehicleType vehicleType){
        Vehicle vehicle = VehicleFactory.createVehicle(userId, licensePlate, model, vehicleType);
        vehicleRepository.save(vehicle);
    }

    public Vehicle getByUserId(UserId userId){
        return vehicleRepository.findByUserId(userId)
                .orElseThrow(() -> new DomainException(ErrorType.USER_NOT_FOUND.getMessage()));
    }

    public Vehicle getVehicleById(VehicleId vehicleId){
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new DomainException(ErrorType.VEHICLE_NOT_FOUND.getMessage()));
    }

    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = vehicleRepository.findAll();
        if (vehicles.isEmpty()) {
            throw new DomainException(ErrorType.VEHICLES_NOT_FOUND.getMessage());
        }
        return vehicles;
    }

}
