package io.santiagovogit.carwashmetro.domain.employee;

import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.error.ErrorMessage;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.time.ZonedDateTime;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotNull;

public class EmployeeFactory {

    private EmployeeFactory() {}

    public static Employee createEmployee(UserId userId,
                                          EmployeePosition employeePosition,
                                          EmployeeStatus employeeStatus,
                                          Salary salary) {

        validateEmployee(userId, employeePosition, employeeStatus);

        return new Employee(
                new EmployeeId(),
                userId,
                employeePosition,
                employeeStatus,
                salary,
                ZonedDateTime.now()
        );
    }

    private static void validateEmployee(UserId userId, EmployeePosition employeePosition, EmployeeStatus employeeStatus) {
        validateNotNull(userId, ErrorMessage.USER_ID_NULL.getMessage());
        validateNotNull(employeePosition, ErrorMessage.EMPLOYEE_POSITION_NULL.getMessage());
        validateNotNull(employeeStatus, ErrorMessage.EMPLOYEE_STATUS_NULL.getMessage());
    }
    
}