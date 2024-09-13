package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.user;

import io.santiagovogit.carwashmetro.application.UserUseCase;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.user.dto.CreateUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody CreateUserDTO request) {
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
    }

}
