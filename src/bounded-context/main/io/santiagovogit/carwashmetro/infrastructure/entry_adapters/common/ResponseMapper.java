package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.common;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.infrastructure.Response;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.cell.dto.CellDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee.dto.EmployeeDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.reservation.dto.ReservationDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.user.dto.UserDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.vehicle.dto.VehicleDTO;

public class ResponseMapper {

    private ResponseMapper() {}

    public static CellDTO toResponse(Cell cell) {
        return new CellDTO(
                cell.getId().getIdentifier(),
                cell.getSpaceNumber().getValue(),
                cell.getVehicleType().getValue(),
                cell.getStatus().getValue(),
                cell.getCreatedAt()
        );
    }

    public static EmployeeDTO toResponse(Employee employee) {
        return new EmployeeDTO(
                employee.getId().getIdentifier(),
                employee.getUserId().getIdentifier(),
                employee.getPosition().getValue(),
                employee.getSalary().getValue(),
                employee.getStatus().getValue(),
                employee.getCreatedAt()
        );
    }

    public static UserDTO toResponse(User user) {
        return new UserDTO(
                user.getId().getIdentifier(),
                user.getDniNumber(),
                user.getDniType().getValue(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getRole().getValue(),
                user.getStatus().getValue(),
                user.getCreatedAt()
        );
    }

    public static VehicleDTO toResponse(Vehicle vehicle) {
        return new VehicleDTO(
                vehicle.getId().getIdentifier(),
                vehicle.getUserId().getIdentifier(),
                vehicle.getLicensePlate(),
                vehicle.getModel(),
                vehicle.getVehicleType().getValue(),
                vehicle.getCreatedAt()
        );
    }

    public static ReservationDTO toResponse(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId().getIdentifier(),
                reservation.getUserId().getIdentifier(),
                reservation.getCellId().getIdentifier(),
                reservation.getVehicleId().getIdentifier(),
                reservation.getReservationCode().getIdentifier(),
                reservation.getStatus().getValue(),
                reservation.getStartTime(),
                reservation.getEndTime(),
                reservation.getCreatedAt()
        );
    }

    public static Response toResponse(String message, String details) {
        return new Response(message, details);
    }

    public static Response toResponse(String message){
        return new Response(message, null);
    }


}
