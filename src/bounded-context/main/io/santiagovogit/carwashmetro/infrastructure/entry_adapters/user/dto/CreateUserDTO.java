package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.user.dto;

public class CreateUserDTO {

    private String firstName;
    private String lastName;
    private String dniNumber;
    private String dniType;
    private String phoneNumber;
    private String email;
    private String role;
    private String status;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDniNumber() {
        return dniNumber;
    }

    public String getDniType() {
        return dniType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

}