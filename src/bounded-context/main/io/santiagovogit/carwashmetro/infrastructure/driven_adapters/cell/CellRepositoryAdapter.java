package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.DataMapper;
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
    public Cell findById(CellId cellId) {
        Optional<CellData> cellData = cellJpaRepository.findById(cellId.getIdentifier());
        return cellData.map(DataMapper::toDomain).orElse(null);
    }

    @Override
    public void save(Cell cell) {
        CellData cellData = DataMapper.toData(cell);
        cellJpaRepository.save(cellData);
    }

    @Override
    public List<Cell> findAll() {
        return cellJpaRepository.findAll().stream()
                .map(DataMapper::toDomain)
                .toList();
    }

    @Override
    public Cell findBySpaceNumber(SpaceNumber spaceNumber) {
        Optional<CellData> cellData = cellJpaRepository.findBySpaceNumber(spaceNumber.getValue());
        return cellData.map(DataMapper::toDomain).orElse(null);
    }

}
