package io.santiagovogit.carwashmetro.domain.user;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorMessage;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;

import java.util.Date;

import static io.santiagovogit.carwashmetro.domain.StringDomainUtils.*;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotEmpty;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotNull;

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

        validateUser(firstName, lastName, dniNumber, dniType, phoneNumber, email, role, status);

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
                new Date()
        );
    }

    public static void validateUser(String firstName,
                                    String lastName,
                                    String dniNumber,
                                    DniType dniType,
                                    String phoneNumber,
                                    String email,
                                    UserRole role,
                                    UserStatus status){

        validateNotEmpty(firstName, ErrorMessage.USER_FIRSTNAME_EMPTY.getMessage());
        validateNotEmpty(lastName, ErrorMessage.USER_LASTNAME_EMPTY.getMessage());
        validateNotEmpty(dniNumber, ErrorMessage.DNI_NUMBER_EMPTY.getMessage());
        validateNotNull(dniType, ErrorMessage.DNI_TYPE_NULL.getMessage());
        validateNotEmpty(phoneNumber, ErrorMessage.PHONE_NUMBER_EMPTY.getMessage());
        validateNotEmpty(email, ErrorMessage.EMAIL_EMPTY.getMessage());
        validateNotNull(role, ErrorMessage.USER_ROLE_NULL.getMessage());
        validateNotNull(status, ErrorMessage.USER_STATUS_NULL.getMessage());

        if (!isNameFormat(firstName)) {
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_NAME_FORMAT.getMessage()
            );
        }

        if (!isLastnameFormat(lastName)) {
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_NAME_FORMAT.getMessage()
            );
        }

        if (!isDniNumberFormat(dniNumber)) {
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_DNI_NUMBER_FORMAT.getMessage()
            );
        }

        if (!isPhoneNumberFormat(phoneNumber)){
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_PHONE_NUMBER_FORMAT.getMessage()
            );
        }

        if(!isEmailFormat(email)){
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_EMAIL_FORMAT.getMessage()
            );
        }

    }

}
