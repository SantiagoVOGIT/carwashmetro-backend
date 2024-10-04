package io.santiagovogit.carwashmetro.application.employee;

import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.employee.ports.EmployeeRepository;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import org.springframework.stereotype.Service;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void ensureEmployeeIdPresent(EmployeeId employeeId) {
        if (isEmpty(employeeId.getValue())) {
            throw new DomainException(ErrorType.EMPLOYEE_ID_EMPTY.getMessage());
        }
    }

    public void ensureEmployeeExists(EmployeeId employeeId) {
        ensureEmployeeIdPresent(employeeId);
        if (!employeeRepository.existsById(employeeId)) {
            throw new DomainException(ErrorType.EMPLOYEE_NOT_FOUND.getMessage());
        }
    }

}
