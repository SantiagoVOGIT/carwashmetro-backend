package io.santiagovogit.carwashmetro.domain.user;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;

import java.util.Date;

import static io.santiagovogit.carwashmetro.domain.StringDomainUtils.*;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotEmpty;

public class UserFactory {

    private UserFactory(){}

    public static User createUser(String firstName,
                                  String lastName,
                                  String dniNumber,
                                  DniType dniType,
                                  String phoneNumber,
                                  String email,
                                  UserRole role,
                                  UserStatus status){

        validateUser(firstName, lastName, dniNumber, phoneNumber, email);

        return new User(
                new UserId(),
                firstName.toUpperCase(),
                lastName.toUpperCase(),
                dniNumber,
                dniType,
                phoneNumber,
                email.toLowerCase(),
                role,
                status,
                new Date()
        );
    }

    private static void validateUser(String firstName,
                                    String lastName,
                                    String dniNumber,
                                    String phoneNumber,
                                    String email){

        validateNotEmpty(firstName, ErrorType.USER_FIRSTNAME_EMPTY.getMessage());
        validateNotEmpty(lastName, ErrorType.USER_LASTNAME_EMPTY.getMessage());
        validateNotEmpty(dniNumber, ErrorType.DNI_NUMBER_EMPTY.getMessage());
        validateNotEmpty(phoneNumber, ErrorType.PHONE_NUMBER_EMPTY.getMessage());
        validateNotEmpty(email, ErrorType.EMAIL_EMPTY.getMessage());

        if (!isNameFormat(firstName)) {
            throw new DomainException(ErrorType.INVALID_NAME_FORMAT.getMessage());
        }
        if (!isLastnameFormat(lastName)) {
            throw new DomainException(ErrorType.INVALID_NAME_FORMAT.getMessage());
        }
        if (!isDniNumberFormat(dniNumber)) {
            throw new DomainException(ErrorType.INVALID_DNI_NUMBER_FORMAT.getMessage());
        }
        if (!isPhoneNumberFormat(phoneNumber)){
            throw new DomainException(ErrorType.INVALID_PHONE_NUMBER_FORMAT.getMessage());
        }
        if(!isEmailFormat(email)){
            throw new DomainException(ErrorType.INVALID_EMAIL_FORMAT.getMessage());
        }
    }

}
