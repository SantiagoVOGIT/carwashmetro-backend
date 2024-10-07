package io.santiagovogit.carwashmetro.application.user;

import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.UserFactory;
import io.santiagovogit.carwashmetro.domain.user.ports.UserRepository;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserUseCase {

    private final UserRepository userRepository;

    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String firstName,
                           String lastName,
                           String dniNumber,
                           DniType dniType,
                           String phoneNumber,
                           String email,
                           UserRole role,
                           UserStatus status) {

        User user = UserFactory.createUser(
                firstName,
                lastName,
                dniNumber,
                dniType,
                phoneNumber,
                email,
                role,
                status
        );
        ensureUniqueUser(email);
        userRepository.save(user);
    }

    public User getUserById(UserId userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new DomainException(ErrorMsg.USER_NOT_FOUND.getMessage()));
    }

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new DomainException(ErrorMsg.USERS_NOT_FOUND.getMessage());
        }
        return users;
    }

    public void ensureUniqueUser(String email){
        Optional<User> isExistingUser = userRepository.findByEmail(email);
        if (isExistingUser.isPresent()) {
            throw new DomainException(ErrorMsg.EMAIL_ALREADY_EXISTS.getMessage());
        }
    }

}