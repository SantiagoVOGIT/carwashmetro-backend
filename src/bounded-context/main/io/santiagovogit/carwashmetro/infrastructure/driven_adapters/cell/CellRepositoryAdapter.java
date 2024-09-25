package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell;

import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.ports.CellRepository;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.common.DataMapper;
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
        CellData cellData = DataMapper.toData(cell);
        cellJpaRepository.save(cellData);
    }

    @Override
    public Optional<Cell> findById(CellId id) {
        Optional<CellData> cellData = cellJpaRepository.findById(id.getIdentifier());
        return cellData.map(DataMapper::toDomain);
    }

    @Override
    public Optional<Cell> findBySpaceNumber(SpaceNumber spaceNumber) {
        Optional<CellData> cellData = cellJpaRepository.findBySpaceNumber(spaceNumber.getValue());
        return cellData.map(DataMapper::toDomain);
    }

    @Override
    public List<Cell> findAll() {
        List<CellData> cellsData = cellJpaRepository.findAll();
        return cellsData.stream()
                .map(DataMapper::toDomain)
                .toList();
    }

}
