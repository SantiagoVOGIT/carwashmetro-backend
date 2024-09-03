package io.santiagovogit.carwashmetro.domain.user.ports;

import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.util.List;

public interface UserRepository {

    void save(User user);

    User findById(UserId employeeId);

    User findByEmail(String email);

    List<User> findAll();
}
