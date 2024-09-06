package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.EmployeeFactory;
import io.santiagovogit.carwashmetro.domain.employee.ports.EmployeeRepository;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.ports.UserRepository;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import org.springframework.stereotype.Service;

@Service
public class EmployeeUseCase {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public EmployeeUseCase(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
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

    private void validateEmployeeDoesExist(UserId userId){
        User user = userRepository.findById(userId);
        if (user != null){
            throw new DomainException("Este usuario ya esta vinculado a otro empleado");
        }
    }

}
