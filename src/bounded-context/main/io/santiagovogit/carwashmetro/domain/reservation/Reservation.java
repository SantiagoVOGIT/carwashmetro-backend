package io.santiagovogit.carwashmetro.domain.reservation;

import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationCode;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.time.ZonedDateTime;

public class Reservation {

    private final ReservationId id;

    private final UserId userId;

    private final CellId cellId;

    private final VehicleId vehicleId;

    private final ReservationCode reservationCode;

    private final ReservationStatus reservationStatus;

    private final ZonedDateTime startTime;

    private final ZonedDateTime endTime;

    private final ZonedDateTime createdAt;

    public Reservation(ReservationId id,
                       UserId userId,
                       CellId cellId,
                       VehicleId vehicleId,
                       ReservationCode reservationCode,
                       ReservationStatus reservationStatus,
                       ZonedDateTime startTime,
                       ZonedDateTime endTime,
                       ZonedDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.cellId = cellId;
        this.vehicleId = vehicleId;
        this.reservationCode = reservationCode;
        this.reservationStatus = reservationStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdAt = createdAt;
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

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "createdAt=" + createdAt +
                ", endTime=" + endTime +
                ", startTime=" + startTime +
                ", reservationStatus=" + reservationStatus +
                ", reservationCode=" + reservationCode +
                ", vehicleId=" + vehicleId +
                ", cellId=" + cellId +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }

}
