package io.santiagovogit.carwashmetro.domain.employee;

import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.time.LocalDateTime;

public class EmployeeFactory {

    private EmployeeFactory() {}

    public static Employee createEmployee(UserId userId,
                                          EmployeePosition position,
                                          Salary salary,
                                          EmployeeStatus status) {
        return new Employee(
                new EmployeeId(),
                userId,
                position,
                salary,
                status,
                LocalDateTime.now()
        );
    }
    
}