package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserData, UUID> {
    Optional<UserData> findByEmail(String email);
}
