package io.santiagovogit.carwashmetro.domain.user;

import io.santiagovogit.carwashmetro.application.user.UserService;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;

import java.time.LocalDateTime;

public class UserFactory {

    private UserFactory() {}

    public static User createUser(String firstName,
                                  String lastName,
                                  String dniNumber,
                                  DniType dniType,
                                  String phoneNumber,
                                  String email,
                                  UserRole role,
                                  UserStatus status) {

        UserService.ensureValidUserDetails(firstName, lastName, dniNumber, phoneNumber, email);

        return new User(
                new UserId(),
                dniNumber,
                dniType,
                firstName,
                lastName,
                phoneNumber,
                email,
                role,
                status,
                LocalDateTime.now()
        );
    }

}
