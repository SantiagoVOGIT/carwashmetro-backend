package io.santiagovogit.carwashmetro.domain.user.ports;

import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

public interface UserRepository {

    void save(User employee);

    User findById(UserId employeeId);

}
