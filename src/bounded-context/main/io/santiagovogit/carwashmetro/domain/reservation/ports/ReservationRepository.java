package io.santiagovogit.carwashmetro.domain.reservation.ports;

import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    void save(Reservation reservation);
    Optional<Reservation> findById(ReservationId reservationId);
    Optional<Reservation> findByUserId(UserId userId);
    List<Reservation> findAll();
    List<Reservation> findAllByUserId(UserId userId);
}
