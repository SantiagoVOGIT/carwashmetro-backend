package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.ReservationFactory;
import io.santiagovogit.carwashmetro.domain.reservation.ports.ReservationRepository;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationUseCase {

    private final ReservationRepository reservationRepository;
    private final CellRepository cellRepository;
    private final CellUseCase cellUseCase;
    private final VehicleUseCase vehicleUseCase;

    public ReservationUseCase(ReservationRepository reservationRepository,
                              CellRepository cellRepository,
                              CellUseCase cellUseCase,
                              VehicleUseCase vehicleUseCase) {
        this.reservationRepository = reservationRepository;
        this.cellRepository        = cellRepository;
        this.cellUseCase           = cellUseCase;
        this.vehicleUseCase        = vehicleUseCase;
    }

    public void createReservation(UserId userId,
                                  CellId cellId, VehicleId vehicleId,
                                  ReservationStatus status,
                                  LocalDateTime startTime,
                                  LocalDateTime endTime) {

        Vehicle vehicle = vehicleUseCase.getVehicleById(vehicleId);
        Cell cell = cellUseCase.getCellById(cellId);

        vehicle.validateCompatibilityWith(cell);
        cell.validateAvailability();

        Reservation reservation = ReservationFactory.createReservartion(userId, cellId, vehicleId, status, startTime, endTime);
        reservationRepository.save(reservation);

        updateCellStatus(cell, CellStatus.OCCUPIED);
    }

    public Reservation getReservationById(ReservationId reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new DomainException(ErrorType.RESERVATION_NOT_FOUND.getMessage()));
    }

    public Reservation getReservationByUserId(UserId userId) {
        return reservationRepository.findByUserId(userId)
                .orElseThrow(() -> new DomainException(ErrorType.USER_NOT_FOUND.getMessage()));
    }

    public List<Reservation> getAllReservationsByUserId(UserId userId) {
        List<Reservation> reservations = reservationRepository.findAllByUserId(userId);
        if (reservations.isEmpty()){
            throw new DomainException(ErrorType.USERS_NOT_FOUND.getMessage());
        }
        return reservations;
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        if (reservations.isEmpty()) {
            throw new DomainException(ErrorType.RESERVATIONS_NOT_FOUND.getMessage());
        }
        return reservations;
    }

    public void cancelReservation(ReservationId reservationId) {
        Reservation reservation = getReservationById(reservationId);
        reservation.cancel(LocalDateTime.now());
        updateReservationAndCell(reservation, CellStatus.AVAILABLE);
    }

    public void rejectReservation(ReservationId reservationId) {
        Reservation reservation = getReservationById(reservationId);
        reservation.reject(LocalDateTime.now());
        updateReservationAndCell(reservation, CellStatus.AVAILABLE);
    }

    public void completeReservation(ReservationId reservationId) {
        Reservation reservation = getReservationById(reservationId);
        reservation.complete(LocalDateTime.now());
        updateReservationAndCell(reservation, CellStatus.AVAILABLE);
    }

    public void confirmReservation(ReservationId reservationId) {
        Reservation reservation = getReservationById(reservationId);
        reservation.confirm(LocalDateTime.now());
        updateReservationAndCell(reservation, CellStatus.OCCUPIED);
    }

    private void updateReservationAndCell(Reservation reservation, CellStatus newCellStatus) {
        reservationRepository.save(reservation);
        Cell cell = cellUseCase.getCellById(reservation.getCellId());
        updateCellStatus(cell, newCellStatus);
    }

    private void updateCellStatus(Cell cell, CellStatus newStatus) {
        cell.updateStatus(newStatus);
        cellRepository.save(cell);
    }

}
