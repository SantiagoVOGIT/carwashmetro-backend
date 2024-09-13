package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee;

import io.santiagovogit.carwashmetro.application.EmployeeUseCase;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.infrastructure.Response;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee.dto.CreateEmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeUseCase employeeUseCase;

    public EmployeeController(EmployeeUseCase employeeUseCase) {
        this.employeeUseCase = employeeUseCase;
    }

    @PostMapping
    public ResponseEntity<Response> createEmployee(@RequestBody CreateEmployeeDTO request) {
        employeeUseCase.createEmployee(
                new UserId(request.getUserId()),
                EmployeePosition.fromValue(request.getPosition()),
                new Salary(request.getSalary()),
                EmployeeStatus.fromValue(request.getStatus())
        );
        Response response = Response.builder()
                .message("Empleado creado correctamente")
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}