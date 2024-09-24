package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CellRepositoryAdapter implements CellRepository {

    private final CellJpaRepository cellJpaRepository;

    public CellRepositoryAdapter(CellJpaRepository cellJpaRepository) {
        this.cellJpaRepository = cellJpaRepository;
    }

    @Override
    public void save(Cell cell) {

    }

    @Override
    public Optional<Cell> findById(CellId id) {
        return Optional.empty();
    }

    @Override
    public Optional<Cell> findBySpaceNumber(SpaceNumber spaceNumber) {
        return Optional.empty();
    }

    @Override
    public List<Cell> findAll() {
        return List.of();
    }

}
