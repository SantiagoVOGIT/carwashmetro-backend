package io.santiagovogit.carwashmetro.domain.user;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;

import java.time.LocalDateTime;

import static io.santiagovogit.carwashmetro.domain.common.DomainUtils.*;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;

public class UserFactory {

    private UserFactory(){}

    public static User createUser(String firstName,
                                  String lastName,
                                  String dniNumber,
                                  DniType dniType,
                                  String phoneNumber,
                                  String email,
                                  UserRole role,
                                  UserStatus status) {

        validateUser(firstName, lastName, dniNumber, dniType, phoneNumber, email, role, status);

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

    private static void validateUser(String firstName,
                                     String lastName,
                                     String dniNumber,
                                     DniType dniType,
                                     String phoneNumber,
                                     String email,
                                     UserRole role,
                                     UserStatus status) {

        if (isNull(dniType)) {
            throw new DomainException(ErrorMsg.DNI_TYPE_EMPTY.getMessage());
        }
        if (isNull(role)) {
            throw new DomainException(ErrorMsg.USER_ROLE_EMPTY.getMessage());
        }
        if (isNull(status)) {
            throw new DomainException(ErrorMsg.USER_STATUS_EMPTY.getMessage());
        }
        if (isEmpty(firstName)) {
            throw new DomainException(ErrorMsg.USER_FIRSTNAME_EMPTY.getMessage());
        }
        if (!isNameFormat(firstName)) {
            throw new DomainException(ErrorMsg.INVALID_NAME_FORMAT.getMessage());
        }
        if (isEmpty(lastName)) {
            throw new DomainException(ErrorMsg.USER_LASTNAME_EMPTY.getMessage());
        }
        if (!isLastnameFormat(lastName)) {
            throw new DomainException(ErrorMsg.INVALID_NAME_FORMAT.getMessage());
        }
        if (isEmpty(dniNumber)) {
            throw new DomainException(ErrorMsg.DNI_NUMBER_EMPTY.getMessage());
        }
        if (!isDniNumberFormat(dniNumber)) {
            throw new DomainException(ErrorMsg.INVALID_DNI_NUMBER_FORMAT.getMessage());
        }
        if (isEmpty(phoneNumber)) {
            throw new DomainException(ErrorMsg.PHONE_NUMBER_EMPTY.getMessage());
        }
        if (!isPhoneNumberFormat(phoneNumber)) {
            throw new DomainException(ErrorMsg.INVALID_PHONE_NUMBER_FORMAT.getMessage());
        }
        if (isEmpty(email)) {
            throw new DomainException(ErrorMsg.EMAIL_EMPTY.getMessage());
        }
        if (!isEmailFormat(email)) {
            throw new DomainException(ErrorMsg.INVALID_EMAIL_FORMAT.getMessage());
        }
    }

}
