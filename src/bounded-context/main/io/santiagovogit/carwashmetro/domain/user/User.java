package io.santiagovogit.carwashmetro.domain.user;

import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;

import java.time.LocalDateTime;

public class User {

    private final UserId id;
    private final String dniNumber;
    private final DniType dniType;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;
    private final UserRole role;
    private final UserStatus status;
    private final LocalDateTime createdAt;

    public User(UserId id,
                String dniNumber,
                DniType dniType,
                String firstName,
                String lastName,
                String phoneNumber,
                String email,
                UserRole role,
                UserStatus status,
                LocalDateTime createdAt) {
        this.id          = id;
        this.dniNumber   = dniNumber;
        this.dniType     = dniType;
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.phoneNumber = phoneNumber;
        this.email       = email;
        this.role        = role;
        this.status      = status;
        this.createdAt   = createdAt;
    }

    public UserId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDniNumber() {
        return dniNumber;
    }

    public DniType getDniType() {
        return dniType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}

