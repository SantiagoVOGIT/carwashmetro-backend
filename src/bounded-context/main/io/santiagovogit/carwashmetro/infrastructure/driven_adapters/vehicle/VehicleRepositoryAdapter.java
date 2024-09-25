package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.vehicle;

import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.ports.VehicleRepository;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.common.DataMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryAdapter implements VehicleRepository {

    private final VehicleJpaRepository vehicleJpaRepository;

    public VehicleRepositoryAdapter(VehicleJpaRepository vehicleJpaRepository) {
        this.vehicleJpaRepository = vehicleJpaRepository;
    }

    @Override
    public void save(Vehicle vehicle) {
        VehicleData vehicleData = DataMapper.toData(vehicle);
        vehicleJpaRepository.save(vehicleData);
    }

    @Override
    public Optional<Vehicle> findById(VehicleId id) {
        Optional<VehicleData> vehicleData = vehicleJpaRepository.findById(id.getIdentifier());
        return vehicleData.map(DataMapper::toDomain);
    }

    @Override
    public Optional<Vehicle> findByUserId(UserId userId) {
        Optional<VehicleData> vehicleData = vehicleJpaRepository.findByUserDataId(userId.getIdentifier());
        return vehicleData.map(DataMapper::toDomain);
    }

    @Override
    public Optional<Vehicle> findByLicensePlate(String licensePlate) {
        Optional<VehicleData> vehicleData = vehicleJpaRepository.findByLicensePlate(licensePlate);
        return vehicleData.map(DataMapper::toDomain);
    }

    @Override
    public List<Vehicle> findAllByUserId(UserId userId) {
        List<VehicleData> vehiclesData = vehicleJpaRepository.findAllByUserDataId(userId.getIdentifier());
        return vehiclesData.stream()
                .map(DataMapper::toDomain)
                .toList();
    }

    @Override
    public List<Vehicle> findAll() {
        List<VehicleData> vehiclesData = vehicleJpaRepository.findAll();
        return vehiclesData.stream()
                .map(DataMapper::toDomain)
                .toList();
    }

}