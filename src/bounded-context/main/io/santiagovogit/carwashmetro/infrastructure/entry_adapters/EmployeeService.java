package io.santiagovogit.carwashmetro.infrastructure.entry_adapters;

import io.santiagovogit.carwashmetro.application.EmployeeUseCase;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeService {

    private final EmployeeUseCase employeeUseCase;

    public EmployeeService(EmployeeUseCase employeeUseCase) {
        this.employeeUseCase = employeeUseCase;
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody CreateEmployeeRequest request){
        employeeUseCase.createEmployee(
                new UserId(request.getUserId()),
                EmployeePosition.fromValue(request.getPosition()),
                Salary.of(request.getSalary()),
                EmployeeStatus.fromValue(request.getStatus())
        );
        return new ResponseEntity<>("Empleado creado correctamente", HttpStatus.CREATED);
    }

    public static class CreateEmployeeRequest {

        private UUID userId;
        private String position;
        private int salary;
        private String status;

        public UUID getUserId() {
            return userId;
        }

        public String getPosition() {
            return position;
        }

        public int getSalary() {
            return salary;
        }

        public String getStatus() {
            return status;
        }

    }


}
