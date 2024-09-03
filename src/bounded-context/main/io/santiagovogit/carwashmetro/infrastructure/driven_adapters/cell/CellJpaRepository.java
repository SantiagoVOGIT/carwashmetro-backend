package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CellJpaRepository extends JpaRepository<CellData, UUID> {
    Optional<CellData> findBySpaceNumber(String spaceNumber);
}
