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
    private final UserService userService;

    public UserUseCase(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService    = userService;
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

    public void updateUser(UserId userId,
                           String firstName,
                           String lastName,
                           String dniNumber,
                           DniType dniType,
                           String phoneNumber,
                           String email,
                           UserRole role,
                           UserStatus status) {

        userService.ensureUserExists(userId);
        User existingUser = userService.getUserByIdOrThrow(userId);

        userService.ensureActiveUser(existingUser.getStatus());
        UserService.ensureValidUserDetails(firstName, lastName, dniNumber, phoneNumber, email);

        User updatedUser = new User(
                existingUser.getId(),
                dniNumber != null ? dniNumber : existingUser.getDniNumber(),
                dniType != null ? dniType : existingUser.getDniType(),
                firstName != null ? firstName : existingUser.getFirstName(),
                lastName != null ? lastName : existingUser.getLastName(),
                phoneNumber != null ? phoneNumber : existingUser.getPhoneNumber(),
                email != null ? email : existingUser.getEmail(),
                role != null ? role : existingUser.getRole(),
                status != null ? status : existingUser.getStatus(),
                existingUser.getCreatedAt()
        );
        userRepository.save(updatedUser);
    }

    public User getUserById(UserId userId){
        return userService.getUserByIdOrThrow(userId);
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