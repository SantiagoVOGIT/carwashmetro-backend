package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationJpaRepository extends JpaRepository<ReservationData, UUID> {
    Optional<ReservationData> findByUserDataId(UUID userId);
    List<ReservationData> findAllByUserDataId(UUID userId);
}
