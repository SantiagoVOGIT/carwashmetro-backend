package io.santiagovogit.carwashmetro.domain.cell.ports;

import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

public interface VehicleRepository {

    void save(Vehicle cell);

    Vehicle findById(VehicleId vehicleid);

}
