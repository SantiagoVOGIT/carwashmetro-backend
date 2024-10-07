package io.santiagovogit.carwashmetro.domain.reservation;

import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationCode;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.time.LocalDateTime;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;

public class ReservationFactory {

    private ReservationFactory() {}

    public static Reservation createReservartion(UserId userId,
                                                 CellId cellId,
                                                 VehicleId vehicleId,
                                                 ReservationStatus status,
                                                 LocalDateTime startTime,
                                                 LocalDateTime endTime) {
        validateReservation(status);
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

    private static void validateReservation(ReservationStatus status) {
        if (isNull(status)) {
            throw new DomainException(ErrorMsg.RESERVATION_STATUS_EMPTY.getMessage());
        }
    }

}
