package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.data;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "_user")
public class UserData {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "dni_number", nullable = false, length = 10)
    private String dniNumber;

    @Column(name = "dni_type", nullable = false, length = Integer.MAX_VALUE)
    private String dniType;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @Column(name = "email", nullable = false, length = 254)
    private String email;

    @Column(name = "role", nullable = false, length = Integer.MAX_VALUE)
    private String role;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private Set<EmployeeData> employeeData = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ReservationData> reservationData = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<VehicleData> vehicleData = new LinkedHashSet<>();

    public Set<VehicleData> getVehicles() {
        return vehicleData;
    }

    public void setVehicles(Set<VehicleData> vehicleData) {
        this.vehicleData = vehicleData;
    }

    public Set<ReservationData> getReservations() {
        return reservationData;
    }

    public void setReservations(Set<ReservationData> reservationData) {
        this.reservationData = reservationData;
    }

    public Set<EmployeeData> getEmployees() {
        return employeeData;
    }

    public void setEmployees(Set<EmployeeData> employeeData) {
        this.employeeData = employeeData;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getDniType() {
        return dniType;
    }

    public void setDniType(String dniType) {
        this.dniType = dniType;
    }

    public String getDniNumber() {
        return dniNumber;
    }

    public void setDniNumber(String dniNumber) {
        this.dniNumber = dniNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}