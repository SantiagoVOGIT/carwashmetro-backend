package io.santiagovogit.carwashmetro.application.employee;

import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.employee.ports.EmployeeRepository;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.DomainException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void ensureEmployeeIdPresent(EmployeeId employeeId) {

    }

    public void ensureEmployeeExists(EmployeeId employeeId) {
        ensureEmployeeIdPresent(employeeId);
        if (!employeeRepository.existsById(employeeId)) {
            throw new DomainException(ErrorMsg.EMPLOYEE_NOT_FOUND.getMessage());
        }
    }

}
