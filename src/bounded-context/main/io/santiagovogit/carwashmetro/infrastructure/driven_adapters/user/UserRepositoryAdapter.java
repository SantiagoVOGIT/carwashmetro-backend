package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.user;

import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.ports.UserRepository;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.DataMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public void save(User user) {
        UserData userData = DataMapper.toData(user);
        userJpaRepository.save(userData);
    }

    @Override
    public User findById(UserId userId) {
        Optional<UserData> userData = userJpaRepository.findById(userId.getIdentifier());
        return userData.map(DataMapper::toDomain).orElse(null);
    }
    
    @Override
    public User findByEmail(String email) {
        Optional<UserData> userData = userJpaRepository.findByEmail(email);
        return userData.map(DataMapper::toDomain).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

}
