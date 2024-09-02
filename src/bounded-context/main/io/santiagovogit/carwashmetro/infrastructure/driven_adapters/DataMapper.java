package io.santiagovogit.carwashmetro.infrastructure.driven_adapters;

import io.santiagovogit.carwashmetro.domain.VehicleType;
import io.santiagovogit.carwashmetro.domain.cell.Cell;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellStatus;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell.CellData;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.data.UserData;

public class DataMapper {

    private DataMapper(){}

    public static Cell toDomain(CellData cellData) {
        return new Cell(
                new CellId(cellData.getId().toString()),
                SpaceNumber.fromValue(cellData.getSpaceNumber()),
                VehicleType.fromValue(cellData.getVehicleType()),
                CellStatus.fromValue(cellData.getStatus()),
                cellData.getCreatedAt()
        );
    }

    public static CellData toData(Cell cell) {
        CellData cellData = new CellData();
        cellData.setId(cell.getId().getIdentifier());
        cellData.setSpaceNumber(cell.getSpaceNumber().getValue());
        cellData.setVehicleType(cell.getVehicleType().getValue());
        cellData.setStatus(cell.getCellStatus().getValue());
        cellData.setCreatedAt(cell.getCreatedAt());
        return cellData;
    }

    public static User toDomain(UserData userData) {
        return new User(
                new UserId(userData.getId().toString()),
                userData.getFirstName(),
                userData.getLastName(),
                userData.getDniNumber(),
                DniType.fromValue(userData.getDniType()),
                userData.getPhoneNumber(),
                userData.getEmail(),
                UserRole.fromValue(userData.getRole()),
                UserStatus.fromValue(userData.getStatus()),
                userData.getCreatedAt()
        );
    }

    public static UserData toData(User user){
        UserData userData = new UserData();
        userData.setId(user.getId().getIdentifier());
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setDniNumber(user.getDniNumber());
        userData.setDniType(user.getDniType().getValue());
        userData.setPhoneNumber(user.getPhoneNumber());
        userData.setEmail(user.getEmail());
        userData.setRole(user.getRole().getValue());
        userData.setStatus(user.getStatus().getValue());
        userData.setCreatedAt(user.getCreatedAt());
        return userData;
    }

}