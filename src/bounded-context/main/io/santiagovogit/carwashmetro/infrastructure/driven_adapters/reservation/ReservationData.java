package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.reservation;

import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.cell.CellData;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.user.UserData;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.vehicle.VehicleData;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "_reservation")
public class ReservationData {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserData userData;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cell_id", nullable = false)
    private CellData cellData;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleData vehicleData;

    @Column(name = "reservation_code", length = 10)
    private String reservationCode;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public VehicleData getVehicleData() {
        return vehicleData;
    }

    public void setVehicleData(VehicleData vehicleData) {
        this.vehicleData = vehicleData;
    }

    public CellData getCellData() {
        return cellData;
    }

    public void setCellData(CellData cellData) {
        this.cellData = cellData;
    }

    public UserData getUser() {
        return userData;
    }

    public void setUser(UserData user) {
        this.userData = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}