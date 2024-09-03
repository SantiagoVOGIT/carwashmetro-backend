package io.santiagovogit.carwashmetro.application;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.UserFactory;
import io.santiagovogit.carwashmetro.domain.user.ports.UserRepository;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;
import org.springframework.stereotype.Service;

@Service
public class UserUseCase {

    private final UserRepository userRepository;

    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String firstName,
                           String lastName,
                           String dniNumber,
                           DniType dniType,
                           String phoneNumber,
                           String email,
                           UserRole role,
                           UserStatus status){

        validateUserDoesNotExist(email);
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
        userRepository.save(user);
        return user;
    }

    public  void validateUserDoesNotExist(String email){
        User user = userRepository.findByEmail(email);
        if (user != null){
            throw new DomainException(ErrorType.EMAIL_ALREADY_EXISTS.getMessage());
        }
    }

}
