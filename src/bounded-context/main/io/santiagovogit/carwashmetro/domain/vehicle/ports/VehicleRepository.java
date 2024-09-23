package io.santiagovogit.carwashmetro.domain.vehicle.ports;

import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    void save(Vehicle vehicle);
    Optional<Vehicle> findById(VehicleId id);
    Optional<Vehicle> findByUserId(UserId userId);
    Optional<Vehicle> findByLicensePlate(String licensePlate);
    List<Vehicle> findAll();
}