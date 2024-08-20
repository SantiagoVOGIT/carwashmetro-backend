package io.santiagovogit.carwashmetro.domain.user.ports;

import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.util.List;

public interface UserRepository {

    void save(User employee);

    User findById(UserId employeeId);

    List<User> findAll();
}
