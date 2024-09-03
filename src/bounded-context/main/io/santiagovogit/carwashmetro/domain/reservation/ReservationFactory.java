package io.santiagovogit.carwashmetro.domain.reservation;

import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationCode;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.util.Date;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotNull;

public class ReservationFactory {

    private ReservationFactory(){}

    public static Reservation createReservartion(UserId userId,
                                                 CellId cellId,
                                                 VehicleId vehicleId,
                                                 ReservationStatus status,
                                                 Date startTime,
                                                 Date endTime){

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
                new Date()
        );
    }

    private static void validateReservation(UserId userId,
                                            CellId cellId,
                                            VehicleId vehicleId,
                                            ReservationStatus reservationStatus){

        validateNotNull(userId, ErrorType.USER_ID_NULL.getMessage());
        validateNotNull(cellId, ErrorType.CELL_ID_NULL.getMessage());
        validateNotNull(vehicleId, ErrorType.VEHICLE_ID_NULL.getMessage());
        validateNotNull(reservationStatus, ErrorType.RESERVATION_STATUS_NULL.getMessage());
    }

}
