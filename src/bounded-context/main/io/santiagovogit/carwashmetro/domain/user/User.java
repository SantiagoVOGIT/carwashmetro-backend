package io.santiagovogit.carwashmetro.domain.user;

import io.santiagovogit.carwashmetro.domain.user.value_objects.DniType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserRole;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserStatus;

import java.util.Date;

public class User {

    private final UserId id;

    private final String firstName;

    private final String lastName;

    private final String dniNumber;

    private final DniType dniType;

    private final String phoneNumber;

    private final String email;

    private final UserRole role;

    private final UserStatus status;

    private final Date createdAt;


    public User(UserId id,
                String firstName,
                String lastName,
                String dniNumber,
                DniType dniType,
                String phoneNumber,
                String email,
                UserRole role,
                UserStatus status,
                Date createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dniNumber = dniNumber;
        this.dniType = dniType;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dniNumber='" + dniNumber + '\'' +
                ", dniType=" + dniType +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }

}
