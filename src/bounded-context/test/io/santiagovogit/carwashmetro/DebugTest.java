package io.santiagovogit.carwashmetro;

import io.santiagovogit.carwashmetro.application.CellUseCase;
import io.santiagovogit.carwashmetro.domain.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.CellFactory;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.EmployeeFactory;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.ReservationFactory;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationStatus;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.UserFactory;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;
import io.santiagovogit.carwashmetro.domain.vehicle.Vehicle;
import io.santiagovogit.carwashmetro.domain.vehicle.VehicleFactory;
import org.junit.jupiter.api.Test;


class DebugTest {

    CellUseCase cellUseCase;

    @Test
    void domainTest(){


        Cell cell1 = CellFactory.createCell(
                SpaceNumber.SPACE_ONE,
                VehicleType.CAR,
                CellStatus.AVAILABLE
        );

        User user1 = UserFactory.createUser(
                "valencía",
                "Valencia",
                "1036928592",
                DniType.CC,
                "3024508215",
                "Fenixcaps@gmail.com",
                UserRole.USER,
                UserStatus.ACTIVE
        );

        Employee employee1 = EmployeeFactory.createEmployee(
                user1.getId(),
                EmployeePosition.CAR_WASHER,
                EmployeeStatus.ACTIVE,
                Salary.of(10000)
        );

        Vehicle vehicle1 = VehicleFactory.createVehicle(
                user1.getId(),
                "AB1234566",
                "Lamborghini gallardo",
                VehicleType.CAR

        );

        Reservation reservation1 = ReservationFactory.createReservartion(
                user1.getId(),
                cell1.getId(),
                vehicle1.getId(),
                ReservationStatus.PENDING,
                null,
                null
        );

        System.out.println(cell1.toString());
        System.out.println(user1.toString());
        System.out.println(employee1.toString());
        System.out.println(vehicle1.toString());
        System.out.println(reservation1.toString());


        try {

        } catch (DomainException e) {

            System.out.println(e.getDetails());
            System.out.println(e.getErrorType());
            System.out.println(e.getMessageKey());
        }

    }

}
