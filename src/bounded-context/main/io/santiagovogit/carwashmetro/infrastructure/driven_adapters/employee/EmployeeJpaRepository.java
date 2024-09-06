package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeData, UUID> {

}
