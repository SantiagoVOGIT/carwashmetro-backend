package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.employee;

import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.ports.EmployeeRepository;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.DataMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryAdapter implements EmployeeRepository {

    private final EmployeeJpaRepository employeeJpaRepository;

    public EmployeeRepositoryAdapter(EmployeeJpaRepository employeeJpaRepository) {
        this.employeeJpaRepository = employeeJpaRepository;
    }

    @Override
    public void save(Employee employee) {
        EmployeeData employeeData = DataMapper.toData(employee);
        employeeJpaRepository.save(employeeData);
    }

    @Override
    public Employee findById(EmployeeId employeeId) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

}
