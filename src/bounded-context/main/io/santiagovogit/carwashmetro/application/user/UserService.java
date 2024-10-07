package io.santiagovogit.carwashmetro.application.user;

import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.user.ports.UserRepository;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import org.springframework.stereotype.Service;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void ensureUserIdPresent(UserId userId) {
        if (isEmpty(userId.getValue())) {
            throw new DomainException(ErrorMsg.USER_ID_EMPTY.getMessage());
        }
    }

    public void ensureUserExists(UserId userId) {
        ensureUserIdPresent(userId);
        if (!userRepository.existsById(userId)) {
            throw new DomainException(ErrorMsg.USER_NOT_FOUND.getMessage());
        }
    }

}
