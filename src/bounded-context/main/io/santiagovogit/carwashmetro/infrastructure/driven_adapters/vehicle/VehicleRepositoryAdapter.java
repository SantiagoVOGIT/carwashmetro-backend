package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.vehicle;

import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.ports.VehicleRepository;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.util.List;
import java.util.Optional;

public class VehicleRepositoryAdapter implements VehicleRepository {

    private final VehicleJpaRepository vehicleJpaRepository;

    public VehicleRepositoryAdapter(VehicleJpaRepository vehicleJpaRepository) {
        this.vehicleJpaRepository = vehicleJpaRepository;
    }

    @Override
    public void save(Vehicle vehicle) {

    }

    @Override
    public Optional<Vehicle> findById(VehicleId id) {
        return Optional.empty();
    }

    @Override
    public Optional<Vehicle> findByUserId(UserId userId) {
        return Optional.empty();
    }

    @Override
    public Optional<Vehicle> findByLicensePlate(String licensePlate) {
        return Optional.empty();
    }

    @Override
    public List<Vehicle> findAll() {
        return List.of();
    }

}
