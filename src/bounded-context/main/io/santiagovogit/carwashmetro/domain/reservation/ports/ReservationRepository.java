package io.santiagovogit.carwashmetro.domain.reservation.ports;

import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;

public interface ReservationRepository {

    void save(Reservation employee);

    Reservation findById(ReservationId reservationId);
}
