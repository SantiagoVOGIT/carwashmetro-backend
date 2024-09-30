package io.santiagovogit.carwashmetro.application.common;

import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.user.ports.UserRepository;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void ensureUserIdPresent(UserId userId) {
        if (isEmpty(userId)) {
            throw new DomainException(ErrorType.USER_ID_EMPTY.getMessage());
        }
    }

    public void ensureUserExists(UserId userId) {
        if (!userRepository.existsById(userId)) {
            throw new DomainException(ErrorType.USER_NOT_FOUND.getMessage());
        }
    }

}
