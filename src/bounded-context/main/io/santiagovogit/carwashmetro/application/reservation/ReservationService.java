package io.santiagovogit.carwashmetro.application.reservation;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.ports.ReservationRepository;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getReservationByIdOrThrow(ReservationId reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new DomainException(ErrorMsg.RESERVATION_NOT_FOUND.getMessage()));
    }

}
