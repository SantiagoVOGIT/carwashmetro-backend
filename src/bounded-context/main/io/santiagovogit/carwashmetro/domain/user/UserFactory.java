package io.santiagovogit.carwashmetro.domain.user;

import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;

import java.time.ZonedDateTime;

public class UserFactory {

    private UserFactory(){}

    public static User createUser(
            String firstName,
            String lastName,
            String dniNumber,
            DniType dniType,
            String phoneNumber,
            String email,
            UserRole role,
            UserStatus status){
        return new User(
                new UserId(),
                firstName,
                lastName,
                dniNumber,
                dniType,
                phoneNumber,
                email,
                role,
                status,
                ZonedDateTime.now()
        );
    }

}
