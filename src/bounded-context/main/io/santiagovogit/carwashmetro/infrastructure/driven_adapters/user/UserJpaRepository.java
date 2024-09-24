package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserData, UUID> {
    Optional<UserData> findByEmail(String email);
}
