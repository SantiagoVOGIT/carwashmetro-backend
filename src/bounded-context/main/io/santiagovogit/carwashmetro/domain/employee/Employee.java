package io.santiagovogit.carwashmetro.domain.employee;

import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.util.Date;

public class Employee {

    private final EmployeeId id;

    private final UserId userId;

    private final EmployeePosition position;

    private final EmployeeStatus status;

    private final Salary salary;

    private final Date createdAt;

    public Employee(EmployeeId id,
                    UserId userId,
                    EmployeePosition position,
                    EmployeeStatus status,
                    Salary salary,
                    Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.position = position;
        this.status = status;
        this.salary = salary;
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

    public EmployeeStatus getStatus() {
        return status;
    }

    public Salary getSalary() {
        return salary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "createdAt=" + createdAt +
                ", salary=" + salary.getValue() +
                ", status=" + status +
                ", position=" + position +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }

}
