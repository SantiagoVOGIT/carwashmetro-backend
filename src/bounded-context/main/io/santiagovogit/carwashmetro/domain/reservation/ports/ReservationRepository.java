package io.santiagovogit.carwashmetro.domain.reservation.ports;

import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;

import java.util.List;

public interface ReservationRepository {

    void save(Reservation employee);

    Reservation findById(ReservationId reservationId);

    List<Reservation> findAll();

}
