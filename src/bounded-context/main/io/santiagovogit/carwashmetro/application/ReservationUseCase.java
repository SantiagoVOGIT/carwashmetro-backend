package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.ReservationFactory;
import io.santiagovogit.carwashmetro.domain.reservation.ports.ReservationRepository;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationUseCase {

    private final ReservationRepository reservationRepository;

    public ReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(UserId userId, CellId cellId, VehicleId vehicleId) {
        Reservation reservation = ReservationFactory.createReservartion(
                userId,
                cellId,
                vehicleId,
                ReservationStatus.PENDING,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        reservationRepository.save(reservation);
    }

    public Reservation getReservationById(ReservationId reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new DomainException(ErrorType.RESERVATION_NOT_FOUND.getMessage()));
    }

    public Reservation getReservationByUserId(UserId userId) {
        return reservationRepository.findByUserId(userId)
                .orElseThrow(() -> new DomainException(ErrorType.USER_NOT_FOUND.getMessage()));
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        if (reservations.isEmpty()) {
            throw new DomainException(ErrorType.RESERVATIONS_NOT_FOUND.getMessage());
        }
        return reservations;
    }

    public List<Reservation> getAllReservationsByUserId(UserId userId) {
        List<Reservation> reservations = reservationRepository.findAllByUserId(userId);
        if (reservations.isEmpty()){
            throw new DomainException(ErrorType.USERS_NOT_FOUND.getMessage());
        }
        return reservations;
    }

}
