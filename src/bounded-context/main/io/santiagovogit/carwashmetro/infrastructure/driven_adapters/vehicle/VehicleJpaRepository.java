package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleJpaRepository extends JpaRepository<VehicleData, UUID> {
}
