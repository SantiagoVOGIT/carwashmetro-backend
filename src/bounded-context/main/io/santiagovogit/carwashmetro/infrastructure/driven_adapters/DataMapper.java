package io.santiagovogit.carwashmetro.infrastructure.driven_adapters;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell.CellData;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.employee.EmployeeData;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.user.UserData;

public class DataMapper {

    private DataMapper(){}

    public static Cell toDomain(CellData cellData) {
        return new Cell(
                new CellId(cellData.getId()),
                SpaceNumber.fromValue(cellData.getSpaceNumber()),
                VehicleType.fromValue(cellData.getVehicleType()),
                CellStatus.fromValue(cellData.getStatus()),
                cellData.getCreatedAt()
        );
    }

    public static CellData toData(Cell cell) {
        CellData cellData = new CellData();
        cellData.setId(cell.getId().getIdentifier());
        cellData.setSpaceNumber(cell.getSpaceNumber().getValue());
        cellData.setVehicleType(cell.getVehicleType().getValue());
        cellData.setStatus(cell.getStatus().getValue());
        cellData.setCreatedAt(cell.getCreatedAt());
        return cellData;
    }

    public static User toDomain(UserData userData) {
        return new User(
                new UserId(userData.getId()),
                userData.getFirstName(),
                DniType.fromValue(userData.getDniType()),
                userData.getDniNumber(),
                userData.getLastName(),
                userData.getPhoneNumber(),
                userData.getEmail(),
                UserRole.fromValue(userData.getRole()),
                UserStatus.fromValue(userData.getStatus()),
                userData.getCreatedAt()
        );
    }

    public static UserData toData(User user){
        UserData userData = new UserData();
        userData.setId(user.getId().getIdentifier());
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setDniNumber(user.getDniNumber());
        userData.setDniType(user.getDniType().getValue());
        userData.setPhoneNumber(user.getPhoneNumber());
        userData.setEmail(user.getEmail());
        userData.setRole(user.getRole().getValue());
        userData.setStatus(user.getStatus().getValue());
        userData.setCreatedAt(user.getCreatedAt());
        return userData;
    }

    public static Employee toDomain(EmployeeData employeeData) {
        return new Employee(
                new EmployeeId(employeeData.getId()),
                new UserId(employeeData.getUserData().getId()),
                EmployeePosition.fromValue(employeeData.getPosition()),
                new Salary(employeeData.getSalary()),
                EmployeeStatus.fromValue(employeeData.getStatus()),
                employeeData.getCreatedAt()
        );
    }

    public static EmployeeData toData(Employee employee) {
        EmployeeData employeeData = new EmployeeData();
        UserData userData = new UserData();
        employeeData.setId(employee.getId().getIdentifier());
        userData.setId(employee.getUserId().getIdentifier());
        employeeData.setUserData(userData);
        employeeData.setPosition(employee.getPosition().getValue());
        employeeData.setSalary(employee.getSalary().getValue());
        employeeData.setStatus(employee.getStatus().getValue());
        employeeData.setCreatedAt(employee.getCreatedAt());
        return employeeData;
    }






}