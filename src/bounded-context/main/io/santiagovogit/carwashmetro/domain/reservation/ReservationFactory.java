package io.santiagovogit.carwashmetro.domain.reservation;

import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationCode;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.time.LocalDateTime;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;

public class ReservationFactory {

    private ReservationFactory() {}

    public static Reservation createReservartion(UserId userId,
                                                 CellId cellId,
                                                 VehicleId vehicleId,
                                                 ReservationStatus status,
                                                 LocalDateTime startTime,
                                                 LocalDateTime endTime) {

        validateReservation(userId, cellId, vehicleId, status);

        return new Reservation(
                new ReservationId(),
                userId,
                cellId,
                vehicleId,
                new ReservationCode(),
                status,
                startTime,
                endTime,
                LocalDateTime.now()
        );
    }

    private static void validateReservation(UserId userId,
                                            CellId cellId,
                                            VehicleId vehicleId,
                                            ReservationStatus status) {

        if (isEmpty(userId.getValue())) {
            throw new DomainException(ErrorType.USER_ID_EMPTY.getMessage());
        }
        if (isEmpty(cellId.getValue())) {
            throw new DomainException(ErrorType.CELL_ID_EMPTY.getMessage());
        }
        if (isEmpty(vehicleId.getValue())) {
            throw new DomainException(ErrorType.VEHICLE_ID_EMPTY.getMessage());
        }
        if (isNull(status)) {
            throw new DomainException(ErrorType.RESERVATION_STATUS_EMPTY.getMessage());
        }
    }

}
