package io.santiagovogit.carwashmetro.domain.employee.ports;

import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    void save(Employee employee);
    Optional<Employee> findById(EmployeeId employeeId);
    Optional<Employee> findByUserId(UserId userId);
    List<Employee> findAll();
    void deleteById(EmployeeId employeeId);
    boolean existsById(EmployeeId employeeId);
}
