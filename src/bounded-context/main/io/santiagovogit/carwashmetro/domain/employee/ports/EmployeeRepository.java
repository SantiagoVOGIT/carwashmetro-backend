package io.santiagovogit.carwashmetro.domain.employee.ports;

import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;

public interface EmployeeRepository {

    void save(Employee employee);

    Employee findById(EmployeeId employeeId);

}
