package io.santiagovogit.carwashmetro.domain.reservation;

import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.error.ErrorMessage;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationCode;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.time.ZonedDateTime;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotNull;

public class ReservationFactory {

    private ReservationFactory(){}

    public static Reservation createReservartion(UserId userId,
                                                 CellId cellId,
                                                 VehicleId vehicleId,
                                                 ReservationStatus reservationStatus,
                                                 ZonedDateTime startTime,
                                                 ZonedDateTime endTime){

        validateReservation(userId, cellId, vehicleId, reservationStatus);

        return new Reservation(
                new ReservationId(),
                userId,
                cellId,
                vehicleId,
                new ReservationCode(),
                reservationStatus,
                startTime,
                endTime,
                ZonedDateTime.now()
        );
    }

    private static void validateReservation(UserId userId,
                                            CellId cellId,
                                            VehicleId vehicleId,
                                            ReservationStatus reservationStatus){

        validateNotNull(userId, ErrorMessage.USER_ID_NULL.getMessage());
        validateNotNull(cellId, ErrorMessage.CELL_ID_NULL.getMessage());
        validateNotNull(vehicleId, ErrorMessage.VEHICLE_ID_NULL.getMessage());
        validateNotNull(reservationStatus, ErrorMessage.RESERVATION_STATUS_NULL.getMessage());
    }

}
