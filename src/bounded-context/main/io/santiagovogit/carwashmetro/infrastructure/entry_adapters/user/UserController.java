package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.user;

import io.santiagovogit.carwashmetro.application.user.UserUseCase;
import io.santiagovogit.carwashmetro.domain.common.InfoType;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;
import io.santiagovogit.carwashmetro.infrastructure.Response;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.common.DTOMapper;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.user.dto.CreateUserDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public ResponseEntity<Response> createUser(@RequestBody CreateUserDTO request) {
        userUseCase.createUser(
                request.firstName(),
                request.lastName(),
                request.dniNumber(),
                DniType.fromValue(request.dniType()),
                request.phoneNumber(), request.email(),
                UserRole.fromValue(request.role()),
                UserStatus.fromValue(request.status())
        );
        Response response = DTOMapper.toDTO(InfoType.SUCCESS_CREATED_USER.getMessage());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userUseCase.getAllUsers();
        List<UserDTO> response = users.stream()
                .map(DTOMapper::toDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable UUID userId) {
        User user = userUseCase.getUserById(new UserId(userId));
        return ResponseEntity.ok(user);
    }

}