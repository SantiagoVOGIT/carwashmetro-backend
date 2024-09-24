package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CellJpaRepository extends JpaRepository<CellData, UUID> {
    Optional<CellData> findBySpaceNumber(String spaceNumber);
}
