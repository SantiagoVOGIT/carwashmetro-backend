package io.santiagovogit.carwashmetro.infrastructure.entry_adapters;

import io.santiagovogit.carwashmetro.application.UserUseCase;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserService {

    private final UserUseCase userUseCase;

    public UserService(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest request) {
        try {
            User user = userUseCase.createUser(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getDniNumber(),
                    DniType.fromValue(request.getDniType()),
                    request.getPhoneNumber(),
                    request.getEmail(),
                    UserRole.fromValue(request.getRole()),
                    UserStatus.fromValue(request.getStatus())
            );
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (DomainException exc) {
            return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public static class CreateUserRequest {

        private String firstName;
        private String lastName;
        private String dniNumber;
        private String dniType;
        private String phoneNumber;
        private String email;
        private String role;
        private String status;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getDniNumber() {
            return dniNumber;
        }

        public String getDniType() {
            return dniType;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public String getRole() {
            return role;
        }

        public String getStatus() {
            return status;
        }

    }

}
