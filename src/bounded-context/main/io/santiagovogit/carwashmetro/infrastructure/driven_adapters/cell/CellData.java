package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell;

import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.data.ReservationData;
import jakarta.persistence.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "_cell")
public class CellData {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "space_number", nullable = false)
    private String spaceNumber;

    @Column(name = "vehicle_type", nullable = false, length = Integer.MAX_VALUE)
    private String vehicleType;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @OneToMany(mappedBy = "cell")
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(String spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
