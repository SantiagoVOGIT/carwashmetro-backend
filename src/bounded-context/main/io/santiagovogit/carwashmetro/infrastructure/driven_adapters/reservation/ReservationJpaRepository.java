package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationJpaRepository extends JpaRepository<ReservationData, UUID> {

}
