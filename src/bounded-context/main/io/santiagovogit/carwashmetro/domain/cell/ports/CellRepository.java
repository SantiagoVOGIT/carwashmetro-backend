package io.santiagovogit.carwashmetro.domain.cell.ports;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;

import java.util.List;

public interface CellRepository
{
    Cell findById(CellId id);

    void save(Cell cell);

    List<Cell> findAll();
}