package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleJpaRepository extends JpaRepository<VehicleData, UUID> {
    Optional<VehicleData> findByUserDataId(UUID userId);
    Optional<VehicleData> findByLicensePlate(String licensePlate);
    List<VehicleData> findAllByUserDataId(UUID userId);
}
