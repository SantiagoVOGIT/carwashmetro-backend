package io.santiagovogit.carwashmetro.application.employee;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.ports.EmployeeRepository;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import org.springframework.stereotype.Service;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeByIdOrThrow(EmployeeId employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new DomainException(ErrorMsg.EMPLOYEE_NOT_FOUND.getMessage()));
    }

    public void ensureEmployeeIdPresent(EmployeeId employeeId) {
        if (isEmpty(employeeId.getValue())) {
            throw new DomainException(ErrorMsg.EMPLOYEE_ID_EMPTY.getMessage());
        }
    }

    public void ensureEmployeeExists(EmployeeId employeeId) {
        ensureEmployeeIdPresent(employeeId);
        if (!employeeRepository.existsById(employeeId)) {
            throw new DomainException(ErrorMsg.EMPLOYEE_NOT_FOUND.getMessage());
        }
    }

}
