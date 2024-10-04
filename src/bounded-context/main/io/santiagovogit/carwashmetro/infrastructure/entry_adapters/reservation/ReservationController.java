package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.reservation;

import io.santiagovogit.carwashmetro.application.reservation.ReservationUseCase;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.CellId;
import io.santiagovogit.carwashmetro.domain.common.InfoType;
import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import io.santiagovogit.carwashmetro.infrastructure.Response;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.common.DTOMapper;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.reservation.dto.CreateReservationDTO;
import io.santiagovogit.carwashmetro.infrastructure.entry_adapters.reservation.dto.ReservationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/reservations")
public class ReservationController {

    private final ReservationUseCase reservationUseCase;

    public ReservationController(ReservationUseCase reservationUseCase) {
        this.reservationUseCase = reservationUseCase;
    }

    @PostMapping
    public ResponseEntity<Response> createReservation(@RequestBody CreateReservationDTO request) {
        reservationUseCase.createReservation(
                new UserId(request.userId()),
                new CellId(request.cellId()),
                new VehicleId(request.vehicleId())
        );
        Response response = DTOMapper.toDTO(InfoType.SUCCESS_CREATED_RESERVATION.getMessage());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable UUID reservationId) {
        Reservation reservation = reservationUseCase.getReservationById(new ReservationId(reservationId));
        ReservationDTO response = DTOMapper.toDTO(reservation);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ReservationDTO> getReservationByUserId(@PathVariable UUID userId) {
        Reservation reservation = reservationUseCase.getReservationByUserId(new UserId(userId));
        ReservationDTO response = DTOMapper.toDTO(reservation);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<Reservation> reservations = reservationUseCase.getAllReservations();
        List<ReservationDTO> response = reservations.stream()
                .map(DTOMapper::toDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}/reservations")
    public ResponseEntity<List<ReservationDTO>> getAllReservationsByUserId(@PathVariable UUID userId) {
        List<Reservation> reservations = reservationUseCase.getAllReservationsByUserId(new UserId(userId));
        List<ReservationDTO> response = reservations.stream()
                .map(DTOMapper::toDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{reservationId}/complete")
    public ResponseEntity<Response> completeReservation(@PathVariable UUID reservationId) {
        reservationUseCase.completeReservation(new ReservationId(reservationId));
        Response response = DTOMapper.toDTO(InfoType.SUCCESS_COMPLETED_RESERVATION.getMessage());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{reservationId}/confirm")
    public ResponseEntity<Response> confirmReservation(@PathVariable UUID reservationId) {
        reservationUseCase.confirmReservation(new ReservationId(reservationId));
        Response response = DTOMapper.toDTO(InfoType.SUCCESS_CONFIRMED_RESERVATION.getMessage());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{reservationId}/reject")
    public ResponseEntity<Response> rejectReservation(@PathVariable UUID reservationId) {
        reservationUseCase.rejectReservation(new ReservationId(reservationId));
        Response response = DTOMapper.toDTO(InfoType.SUCCESS_REJECTED_RESERVATION.getMessage());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{reservationId}/cancel")
    public ResponseEntity<Response> cancelReservation(@PathVariable UUID reservationId) {
        reservationUseCase.cancelReservation(new ReservationId(reservationId));
        Response response = DTOMapper.toDTO(InfoType.SUCCES_CANCELED_RESERVATION.getMessage());
        return ResponseEntity.ok(response);
    }

}
