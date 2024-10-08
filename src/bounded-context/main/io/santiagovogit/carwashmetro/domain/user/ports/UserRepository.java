package io.santiagovogit.carwashmetro.domain.user.ports;

import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(UserId userId);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    boolean existsById(UserId id);
}
