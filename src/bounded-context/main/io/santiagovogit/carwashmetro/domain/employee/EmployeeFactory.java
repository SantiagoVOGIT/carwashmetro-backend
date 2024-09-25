package io.santiagovogit.carwashmetro.domain.employee;

import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.time.LocalDateTime;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;

public class EmployeeFactory {

    private EmployeeFactory() {}

    public static Employee createEmployee(UserId userId,
                                          EmployeePosition position,
                                          Salary salary,
                                          EmployeeStatus status) {

        validateEmployee(userId, position, status);
        return new Employee(
                new EmployeeId(),
                userId,
                position,
                salary,
                status,
                LocalDateTime.now()
        );
    }

    private static void validateEmployee(UserId userId, EmployeePosition position, EmployeeStatus status) {
        if (isEmpty(userId.getValue())) {
            throw new DomainException(ErrorType.USER_ID_EMPTY.getMessage());
        }
        if (isNull(position)) {
            throw new DomainException(ErrorType.EMPLOYEE_POSITION_EMPTY.getMessage());
        }
        if (isNull(status)) {
            throw new DomainException(ErrorType.EMPLOYEE_STATUS_EMPTY.getMessage());
        }
    }
    
}