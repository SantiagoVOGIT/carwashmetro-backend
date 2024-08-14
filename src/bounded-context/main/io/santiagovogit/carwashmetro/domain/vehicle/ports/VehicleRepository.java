package io.santiagovogit.carwashmetro.domain.vehicle.ports;

import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

public interface VehicleRepository {

    void save(Vehicle employee);

    Vehicle findById(VehicleId employeeId);

}
