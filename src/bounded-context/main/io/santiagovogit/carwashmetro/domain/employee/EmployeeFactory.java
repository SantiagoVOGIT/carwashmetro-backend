package io.santiagovogit.carwashmetro.domain.employee;

import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.util.Date;

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
                new Date()
        );
    }

    private static void validateEmployee(UserId userId, EmployeePosition employeePosition, EmployeeStatus employeeStatus) {
        validateNotNull(userId, ErrorType.USER_ID_NULL.getMessage());
        validateNotNull(employeePosition, ErrorType.EMPLOYEE_POSITION_NULL.getMessage());
        validateNotNull(employeeStatus, ErrorType.EMPLOYEE_STATUS_NULL.getMessage());
    }
    
}