package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.application.common.CellService;
import io.santiagovogit.carwashmetro.application.common.UserService;
import io.santiagovogit.carwashmetro.application.common.VehicleService;
import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
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
    private final CellRepository cellRepository;
    private final UserService userService;
    private final CellService cellService;
    private final VehicleService vehicleService;

    public ReservationUseCase(ReservationRepository reservationRepository, CellRepository cellRepository,
                              UserService userService,
                              CellService cellService,
                              VehicleService vehicleService) {
        this.reservationRepository = reservationRepository;
        this.cellRepository        = cellRepository;
        this.userService           = userService;
        this.cellService           = cellService;
        this.vehicleService        = vehicleService;
    }

    public void createReservation(UserId userId, CellId cellId, VehicleId vehicleId) {
        ensureCellState(cellId, userId, vehicleId);
        Reservation reservation = ReservationFactory.createReservartion(
                userId, cellId, vehicleId,
                ReservationStatus.PENDING,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        Cell cell = cellRepository.findById(cellId).get();
        cell.setStatus(CellStatus.RESERVED);
        cellRepository.save(cell);
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
        if (reservations.isEmpty()){
            throw new DomainException(ErrorType.RESERVATION_NOT_FOUND.getMessage());
        }
        return reservations;
    }

    private void ensureCellState(CellId cellId, UserId userId, VehicleId vehicleId) {
        userService.ensureUserExists(userId);
        cellService.ensureCellExists(cellId);
        vehicleService.ensureVehicleExists(vehicleId);
    }

}
