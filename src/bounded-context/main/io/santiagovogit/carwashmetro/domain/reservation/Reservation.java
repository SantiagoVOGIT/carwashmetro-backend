package io.santiagovogit.carwashmetro.domain.reservation;

import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationCode;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.time.LocalDateTime;

public class Reservation {

    private final ReservationId id;
    private final UserId userId;
    private final CellId cellId;
    private final VehicleId vehicleId;
    private final ReservationCode reservationCode;
    private final ReservationStatus status;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final LocalDateTime createdAt;

    public Reservation(ReservationId id,
                       UserId userId,
                       CellId cellId,
                       VehicleId vehicleId,
                       ReservationCode reservationCode,
                       ReservationStatus status,
                       LocalDateTime startTime,
                       LocalDateTime endTime,
                       LocalDateTime createdAt) {
        this.id              = id;
        this.userId          = userId;
        this.cellId          = cellId;
        this.vehicleId       = vehicleId;
        this.reservationCode = reservationCode;
        this.status          = status;
        this.startTime       = startTime;
        this.endTime         = endTime;
        this.createdAt       = createdAt;
    }

    public ReservationId getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public CellId getCellId() {
        return cellId;
    }

    public VehicleId getVehicleId() {
        return vehicleId;
    }

    public ReservationCode getReservationCode() {
        return reservationCode;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
