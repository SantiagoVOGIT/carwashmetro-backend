package io.santiagovogit.carwashmetro.application.user;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.user.User;
import io.santiagovogit.carwashmetro.domain.user.ports.UserRepository;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;
import org.springframework.stereotype.Service;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;
import static io.santiagovogit.carwashmetro.domain.common.DomainUtils.*;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByIdOrThrow(UserId userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new DomainException(ErrorMsg.USER_NOT_FOUND.getMessage()));
    }

    public void ensureUserIdPresent(UserId userId) {
        if (isEmpty(userId.getValue())) {
            throw new DomainException(ErrorMsg.USER_ID_EMPTY.getMessage());
        }
    }

    public void ensureActiveUser(UserStatus userStatus) {
        if (userStatus != UserStatus.ACTIVE ) {
            throw new DomainException(ErrorMsg.USER_NOT_ACTIVE.getMessage());
        }
    }

    public void ensureUserExists(UserId userId) {
        ensureUserIdPresent(userId);
        if (!userRepository.existsById(userId)) {
            throw new DomainException(ErrorMsg.USER_NOT_FOUND.getMessage());
        }
    }

    public static void ensureValidUserDetails(String firstName,
                                       String lastName,
                                       String dniNumber,
                                       String phoneNumber,
                                       String email) {

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
