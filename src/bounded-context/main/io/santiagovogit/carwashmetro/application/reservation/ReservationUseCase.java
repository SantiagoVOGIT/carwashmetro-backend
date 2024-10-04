package io.santiagovogit.carwashmetro.application.reservation;

import io.santiagovogit.carwashmetro.application.cell.CellService;
import io.santiagovogit.carwashmetro.application.user.UserService;
import io.santiagovogit.carwashmetro.application.vehicle.VehicleService;
import io.santiagovogit.carwashmetro.domain.cell.*;
import io.santiagovogit.carwashmetro.domain.cell.ports.*;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.*;
import io.santiagovogit.carwashmetro.domain.common.*;
import io.santiagovogit.carwashmetro.domain.error.*;
import io.santiagovogit.carwashmetro.domain.reservation.*;
import io.santiagovogit.carwashmetro.domain.reservation.ports.*;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.*;
import io.santiagovogit.carwashmetro.domain.user.value_objects.*;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationUseCase {

    private final ReservationRepository reservationRepository;
    private final CellRepository cellRepository;
    private final UserService userService;
    private final CellService cellService;
    private final VehicleService vehicleService;

    public ReservationUseCase(ReservationRepository reservationRepository,
                              CellRepository cellRepository,
                              UserService userService,
                              CellService cellService,
                              VehicleService vehicleService) {
        this.reservationRepository = reservationRepository;
        this.cellRepository = cellRepository;
        this.userService = userService;
        this.cellService = cellService;
        this.vehicleService = vehicleService;
    }

    public void createReservation(UserId userId, CellId cellId, VehicleId vehicleId) {
        validateReservationCreation(userId, cellId, vehicleId);
        Reservation reservation = ReservationFactory.createReservartion(
                userId,
                cellId,
                vehicleId,
                ReservationStatus.PENDING,
                null,
                null
        );
        updateCellStatus(cellId, CellStatus.RESERVED);
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
        userService.ensureUserExists(userId);
        List<Reservation> reservations = reservationRepository.findAllByUserId(userId);
        if (reservations.isEmpty()) {
            throw new DomainException(ErrorType.RESERVATION_NOT_FOUND.getMessage());
        }
        return reservations;
    }

    public void completeReservation(ReservationId reservationId) {
        updateReservationStatus(reservationId,
                ReservationStatus.COMPLETED,
                CellStatus.AVAILABLE
        );
    }

    public void confirmReservation(ReservationId reservationId) {
        updateReservationStatus(
                reservationId,
                ReservationStatus.CONFIRMED,
                CellStatus.OCCUPIED
        );
    }

    public void rejectReservation(ReservationId reservationId) {
        updateReservationStatus(
                reservationId,
                ReservationStatus.REJECTED,
                CellStatus.AVAILABLE
        );
    }

    public void cancelReservation(ReservationId reservationId) {
        updateReservationStatus(
                reservationId,
                ReservationStatus.CANCELLED,
                CellStatus.AVAILABLE
        );
    }

    private void validateReservationCreation(UserId userId, CellId cellId, VehicleId vehicleId) {
        userService.ensureUserExists(userId);
        cellService.ensureCellExists(cellId);
        vehicleService.ensureVehicleExists(vehicleId);
        validateCellAvailability(cellId);
    }

    private void validateCellAvailability(CellId cellId) {
        CellStatus cellStatus = cellRepository.findById(cellId)
                .orElseThrow(() -> new DomainException(ErrorType.CELL_NOT_FOUND.getMessage()))
                .getStatus();
        Cell.checkAvailability(cellStatus);
    }

    private void updateReservationStatus(ReservationId reservationId,
                                         ReservationStatus reservationStatus,
                                         CellStatus cellStatus) {
        Reservation reservation = getReservationById(reservationId);
        validateStatusChange(reservation);
        updateReservation(reservation, reservationStatus);
        updateCellStatus(reservation.getCellId(), cellStatus);
        reservationRepository.save(reservation);
    }

    private void validateStatusChange(Reservation reservation) {
        if (reservation.getStatus() == ReservationStatus.CANCELLED ||
                reservation.getStatus() == ReservationStatus.REJECTED ||
                reservation.getStatus() == ReservationStatus.COMPLETED) {
            throw new DomainException(ErrorType.INVALID_RESERVATION_STATUS_CHANGE.getMessage());
        }
    }

    private void updateReservation(Reservation reservation, ReservationStatus status) {
        reservation.setStatus(status);
        updateReservationTimes(reservation, status);
    }

    private void updateCellStatus(CellId cellId, CellStatus status) {
        Cell cell = cellRepository.findById(cellId)
                .orElseThrow(() -> new DomainException(ErrorType.CELL_NOT_FOUND.getMessage()));
        cell.setStatus(status);
        cellRepository.save(cell);
    }

    private void updateReservationTimes(Reservation reservation, ReservationStatus status) {
        switch (status) {
            case CANCELLED, COMPLETED, REJECTED:
                reservation.setEndTime(LocalDateTime.now());
                break;
            case CONFIRMED:
                reservation.setStartTime(LocalDateTime.now());
                break;
            case PENDING:
            default:
                reservation.setStartTime(null);
                reservation.setEndTime(null);
                break;
        }
    }

}