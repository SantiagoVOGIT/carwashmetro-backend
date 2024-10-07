package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee;

import io.santiagovogit.carwashmetro.application.employee.EmployeeUseCase;
import io.santiagovogit.carwashmetro.domain.common.messages.InfoMsg;
import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeePosition;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeStatus;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.Salary;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.infrastructure.Response;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.common.DTOMapper;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee.dto.CreateEmployeeDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee.dto.EmployeeDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee.dto.UpdateEmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeUseCase employeeUseCase;

    public EmployeeController(EmployeeUseCase employeeUseCase) {
        this.employeeUseCase = employeeUseCase;
    }

    @PostMapping
    public ResponseEntity<Response> createEmployee(@RequestBody CreateEmployeeDTO request) {
        employeeUseCase.createEmployee(
                new UserId(request.userId()),
                EmployeePosition.fromValue(request.position()),
                new Salary(request.salary()),
                EmployeeStatus.fromValue(request.status())
        );
        Response response = DTOMapper.toDTO(InfoMsg.SUCCESS_CREATED_EMPLOYEE.getMessage());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeByid(@PathVariable UUID employeeId){
        Employee employee = employeeUseCase.getEmployeeById(new EmployeeId(employeeId));
        EmployeeDTO response = DTOMapper.toDTO(employee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<EmployeeDTO> getEmployeeByUserId(@PathVariable UUID userId) {
        Employee employee = employeeUseCase.getEmployeeByUserId(new UserId(userId));
        EmployeeDTO response = DTOMapper.toDTO(employee);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<Employee> employees = employeeUseCase.getAllEmployees();
        List<EmployeeDTO> response = employees.stream()
                .map(DTOMapper::toDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Response> deleteEmployeeById(@PathVariable UUID employeeId) {
        employeeUseCase.deleteEmployeeById(new EmployeeId(employeeId));
        Response response = DTOMapper.toDTO(InfoMsg.SUCCESS_DELETED_EMPLOYEE.getMessage());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Response> updateEmployee(@PathVariable UUID employeeId,
                                                   @RequestBody UpdateEmployeeDTO request) {
        employeeUseCase.updateEmployee(
                new EmployeeId(employeeId),
                EmployeePosition.fromValue(request.position()),
                new Salary(request.salary()),
                EmployeeStatus.fromValue(request.status())
        );
        Response response = DTOMapper.toDTO(InfoMsg.SUCCESS_UPDATED_EMPLOYEE.getMessage());
        return ResponseEntity.ok(response);
    }

}