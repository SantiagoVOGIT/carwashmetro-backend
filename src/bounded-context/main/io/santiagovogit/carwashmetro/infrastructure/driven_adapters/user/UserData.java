package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.user;

import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.employee.EmployeeData;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.reservation.ReservationData;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.vehicle.VehicleData;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "_user")
public class UserData {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "dni_type", nullable = false, length = Integer.MAX_VALUE)
    private String dniType;

    @Column(name = "dni_number", nullable = false, length = 10)
    private String dniNumber;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @Column(name = "email", nullable = false, length = 254)
    private String email;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "role", nullable = false, length = Integer.MAX_VALUE)
    private String role;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "userData")
    private Set<EmployeeData> employees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userData")
    private Set<ReservationData> reservations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userData")
    private Set<VehicleData> vehicles = new LinkedHashSet<>();

    public Set<VehicleData> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<VehicleData> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<ReservationData> getReservations() {
        return reservations;
    }

    public void setReservations(Set<ReservationData> reservations) {
        this.reservations = reservations;
    }

    public Set<EmployeeData> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeData> employees) {
        this.employees = employees;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDniNumber() {
        return dniNumber;
    }

    public void setDniNumber(String dniNumber) {
        this.dniNumber = dniNumber;
    }

    public String getDniType() {
        return dniType;
    }

    public void setDniType(String dniType) {
        this.dniType = dniType;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}