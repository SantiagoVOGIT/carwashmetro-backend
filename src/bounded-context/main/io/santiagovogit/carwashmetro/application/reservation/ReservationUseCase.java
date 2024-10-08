package io.santiagovogit.carwashmetro.application.reservation;

import io.santiagovogit.carwashmetro.application.cell.CellService;
import io.santiagovogit.carwashmetro.application.user.UserService;
import io.santiagovogit.carwashmetro.application.vehicle.VehicleService;
import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.ReservationFactory;
import io.santiagovogit.carwashmetro.domain.reservation.ports.ReservationRepository;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationUseCase {

    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;
    private final UserService userService;
    private final CellService cellService;
    private final VehicleService vehicleService;

    public ReservationUseCase(ReservationRepository reservationRepository,
                              ReservationService reservationService,
                              UserService userService,
                              CellService cellService,
                              VehicleService vehicleService) {
        this.reservationRepository = reservationRepository;
        this.reservationService    = reservationService;
        this.userService           = userService;
        this.cellService           = cellService;
        this.vehicleService        = vehicleService;
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
        cellService.updateCellStatus(cellId, CellStatus.RESERVED);
        reservationRepository.save(reservation);
    }

    public Reservation getReservationById(ReservationId reservationId) {
        return reservationService.getReservationByIdOrThrow(reservationId);
    }

    public Reservation getReservationByUserId(UserId userId) {
        return reservationRepository.findByUserId(userId)
                .orElseThrow(() -> new DomainException(ErrorMsg.USER_NOT_FOUND.getMessage()));
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        if (reservations.isEmpty()) {
            throw new DomainException(ErrorMsg.RESERVATIONS_NOT_FOUND.getMessage());
        }
        return reservations;
    }

    public List<Reservation> getAllReservationsByUserId(UserId userId) {
        userService.ensureUserExists(userId);
        List<Reservation> reservations = reservationRepository.findAllByUserId(userId);
        if (reservations.isEmpty()) {
            throw new DomainException(ErrorMsg.RESERVATION_NOT_FOUND.getMessage());
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

        Cell cell = cellService.getCellByIdOrThrow(cellId);
        Vehicle vehicle = vehicleService.getVehicleByIdOrThrow(vehicleId);

        cell.checkAvailability();
        cell.checkVehicleCompatibility(vehicle.getVehicleType());
    }

    private void updateReservationStatus(ReservationId reservationId,
                                         ReservationStatus reservationStatus,
                                         CellStatus cellStatus) {

        Reservation reservation = reservationService.getReservationByIdOrThrow(reservationId);
        validateStatusChange(reservation);
        updateReservation(reservation, reservationStatus);
        cellService.updateCellStatus(reservation.getCellId(), cellStatus);
        reservationRepository.save(reservation);
    }

    private void validateStatusChange(Reservation reservation) {
        if (reservation.getStatus() == ReservationStatus.CANCELLED ||
                reservation.getStatus() == ReservationStatus.REJECTED ||
                reservation.getStatus() == ReservationStatus.COMPLETED) {
            throw new DomainException(ErrorMsg.INVALID_RESERVATION_STATUS_CHANGE.getMessage());
        }
    }

    private void updateReservation(Reservation reservation, ReservationStatus status) {
        reservation.setStatus(status);
        updateReservationTimes(reservation, status);
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