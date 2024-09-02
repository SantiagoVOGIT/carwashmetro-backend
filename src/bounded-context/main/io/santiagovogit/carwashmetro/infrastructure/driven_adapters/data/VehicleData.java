package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.data;

import jakarta.persistence.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "_vehicle")
public class VehicleData {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserData userData;

    @Column(name = "license_plate", nullable = false, length = 9)
    private String licensePlate;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "vehicle_type", nullable = false, length = Integer.MAX_VALUE)
    private String vehicleType;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @OneToMany(mappedBy = "vehicle")
    private Set<ReservationData> reservationData = new LinkedHashSet<>();

    public Set<ReservationData> getReservations() {
        return reservationData;
    }

    public void setReservations(Set<ReservationData> reservationData) {
        this.reservationData = reservationData;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
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

    public UserData getUser() {
        return userData;
    }

    public void setUser(UserData userData) {
        this.userData = userData;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}