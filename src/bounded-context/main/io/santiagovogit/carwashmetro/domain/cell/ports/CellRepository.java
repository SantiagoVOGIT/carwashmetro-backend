package io.santiagovogit.carwashmetro.domain.cell.ports;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;

import java.util.List;
import java.util.Optional;

public interface CellRepository {
    void save(Cell cell);
    Optional<Cell> findById(CellId id);
    Optional<Cell> findBySpaceNumber(SpaceNumber spaceNumber);
    List<Cell> findAll();
}
