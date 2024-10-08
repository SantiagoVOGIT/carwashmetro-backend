package io.santiagovogit.carwashmetro.application.employee;

import io.santiagovogit.carwashmetro.application.user.UserService;
import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.EmployeeFactory;
import io.santiagovogit.carwashmetro.domain.employee.ports.EmployeeRepository;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeUseCase {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private final UserService userService;

    public EmployeeUseCase(EmployeeService employeeService, EmployeeRepository employeeRepository, UserService userService) {
        this.employeeService    = employeeService;
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

    public void updateEmployee(EmployeeId employeeId,
                               EmployeePosition newPosition,
                               Salary newSalary,
                               EmployeeStatus newStatus) {

        employeeService.ensureEmployeeExists(employeeId);
        Employee existingEmployee = employeeService.getEmployeeByIdOrThrow(employeeId);

        Employee updatedEmployee = new Employee(
                existingEmployee.getId(),
                existingEmployee.getUserId(),
                newPosition != null ? newPosition : existingEmployee.getPosition(),
                newSalary != null ? newSalary : existingEmployee.getSalary(),
                newStatus != null ? newStatus : existingEmployee.getStatus(),
                existingEmployee.getCreatedAt()
        );
        employeeRepository.save(updatedEmployee);
    }

    public Employee getEmployeeById(EmployeeId employeeId){
        return employeeService.getEmployeeByIdOrThrow(employeeId);
    }

    public Employee getEmployeeByUserId(UserId userId){
        return employeeRepository.findByUserId(userId)
                .orElseThrow(() -> new DomainException(ErrorMsg.USER_NOT_FOUND.getMessage()));
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new DomainException(ErrorMsg.EMPLOYEES_NOT_FOUND.getMessage());
        }
        return employees;
    }

    public void deleteEmployeeById(EmployeeId employeeId) {
        employeeService.ensureEmployeeExists(employeeId);
        employeeRepository.deleteById(employeeId);
    }

    private void ensureUniqueEmployee(UserId userId) {
        Optional<Employee> employee = employeeRepository.findByUserId(userId);
        if (employee.isPresent()) {
            throw new DomainException(ErrorMsg.EMPLOYEE_ALREADY_EXIST.getMessage());
        }
    }

}
