package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.reservation.dto;

import java.util.UUID;

public class CreateReservationDTO {

    private UUID userId;
    private UUID cellId;
    private UUID vehicleId;

    public UUID getUserId() {
        return userId;
    }

    public UUID getCellId() {
        return cellId;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

}
