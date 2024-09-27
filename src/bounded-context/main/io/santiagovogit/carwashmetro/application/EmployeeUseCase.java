package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.application.common.UserService;
import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.EmployeeFactory;
import io.santiagovogit.carwashmetro.domain.employee.ports.EmployeeRepository;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeUseCase {

    private final EmployeeRepository employeeRepository;
    private final UserService userService;

    public EmployeeUseCase(EmployeeRepository employeeRepository, UserService userService) {
        this.employeeRepository = employeeRepository;
        this.userService        = userService;
    }

    public void createEmployee(UserId userId,
                               EmployeePosition position,
                               Salary salary,
                               EmployeeStatus status) {
        userService.ensureUserExists(userId);
        Employee employee = EmployeeFactory.createEmployee(userId, position, salary, status);
        ensureUniqueEmployee(userId);
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(EmployeeId employeeId){
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new DomainException(ErrorType.EMPLOYEE_NOT_FOUND.getMessage()));
    }

    public Employee getEmployeeByUserId(UserId userId){
        return employeeRepository.findByUserId(userId)
                .orElseThrow(() -> new DomainException(ErrorType.USER_NOT_FOUND.getMessage()));
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new DomainException(ErrorType.EMPLOYEES_NOT_FOUND.getMessage());
        }
        return employees;
    }

    private void ensureUniqueEmployee(UserId userId) {
        Optional<Employee> employee = employeeRepository.findByUserId(userId);
        if (employee.isPresent()) {
            throw new DomainException(ErrorType.EMPLOYEE_ALREADY_EXIST.getMessage());
        }
    }

}
