package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.employee;

import io.santiagovogit.carwashmetro.domain.employee.Employee;
import io.santiagovogit.carwashmetro.domain.employee.ports.EmployeeRepository;
import io.santiagovogit.carwashmetro.domain.employee.value_objects.EmployeeId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.common.DataMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public Optional<Employee> findById(EmployeeId employeeId) {
        Optional<EmployeeData> employeeData = employeeJpaRepository.findById(employeeId.getIdentifier());
        return employeeData.map(DataMapper::toDomain);
    }

    @Override
    public Optional<Employee> findByUserId(UserId userId) {
        Optional<EmployeeData> employeeData = employeeJpaRepository.findByUserDataId(userId.getIdentifier());
        return employeeData.map(DataMapper::toDomain);
    }

    @Override
    public List<Employee> findAll() {
        List<EmployeeData> employeesData = employeeJpaRepository.findAll();
        return employeesData.stream()
                .map(DataMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(EmployeeId employeeId) {
        employeeJpaRepository.deleteById(employeeId.getIdentifier());
    }

    @Override
    public boolean existsById(EmployeeId employeeId) {
        return employeeJpaRepository.existsById(employeeId.getIdentifier());
    }

}
