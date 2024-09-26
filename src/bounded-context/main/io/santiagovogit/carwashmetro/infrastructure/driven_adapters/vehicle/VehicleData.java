package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.vehicle;

import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.reservation.ReservationData;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.user.UserData;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "_vehicle")
public class VehicleData {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "license_plate", nullable = false, length = 9)
    private String licensePlate;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "vehicle_type", nullable = false, length = Integer.MAX_VALUE)
    private String vehicleType;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserData userData;

    @OneToMany(mappedBy = "vehicleData")
    private Set<ReservationData> reservationsData = new LinkedHashSet<>();

    public Set<ReservationData> getReservationsData() {
        return reservationsData;
    }

    public void setReservationsData(Set<ReservationData> reservationsData) {
        this.reservationsData = reservationsData;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

}