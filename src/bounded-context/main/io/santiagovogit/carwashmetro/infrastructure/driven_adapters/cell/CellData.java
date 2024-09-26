package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell;

import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.reservation.ReservationData;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "_cell")
public class CellData {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "space_number", nullable = false, length = Integer.MAX_VALUE)
    private String spaceNumber;

    @Column(name = "vehicle_type", nullable = false, length = Integer.MAX_VALUE)
    private String vehicleType;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "cellData")
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
