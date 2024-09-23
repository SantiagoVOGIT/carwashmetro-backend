package io.santiagovogit.carwashmetro.domain.employee;

import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.time.LocalDateTime;

public class Employee {

    private final EmployeeId id;
    private final UserId userId;
    private final EmployeePosition position;
    private final Salary salary;
    private final EmployeeStatus status;
    private final LocalDateTime createdAt;

    public Employee(EmployeeId id,
                    UserId userId,
                    EmployeePosition position,
                    Salary salary,
                    EmployeeStatus status,
                    LocalDateTime createdAt) {
        this.id        = id;
        this.userId    = userId;
        this.position  = position;
        this.salary    = salary;
        this.status    = status;
        this.createdAt = createdAt;
    }

    public EmployeeId getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public Salary getSalary() {
        return salary;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
