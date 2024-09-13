package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.EmployeeFactory;
import io.santiagovogit.carwashmetro.domain.employee.ports.EmployeeRepository;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public EmployeeUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(UserId userId,
                               EmployeePosition position,
                               Salary salary,
                               EmployeeStatus status) {

        validateEmployeeDoesExist(userId);

        Employee employee = EmployeeFactory.createEmployee(
                userId,
                position,
                salary,
                status
        );
        employeeRepository.save(employee);
    }

    private void validateEmployeeDoesExist(UserId userId) {
        Optional<Employee> employee = employeeRepository.findByUserId(userId);
        if (employee.isPresent()) {
            throw new DomainException(ErrorType.EMPLOYEE_ALREADY_EXIST.getMessage());
        }
    }

}
