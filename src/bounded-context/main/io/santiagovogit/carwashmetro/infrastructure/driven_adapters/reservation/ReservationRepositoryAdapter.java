package io.santiagovogit.carwashmetro.infrastructure.driven_adapters.reservation;

import io.santiagovogit.carwashmetro.domain.reservation.Reservation;
import io.santiagovogit.carwashmetro.domain.reservation.ports.ReservationRepository;
import io.santiagovogit.carwashmetro.domain.reservation.value_objects.ReservationId;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.infrastructure.driven_adapters.common.DataMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepositoryAdapter implements ReservationRepository {

    private final ReservationJpaRepository reservationJpaRepository;

    public ReservationRepositoryAdapter(ReservationJpaRepository reservationJpaRepository) {
        this.reservationJpaRepository = reservationJpaRepository;
    }

    @Override
    public void save(Reservation reservation) {
        ReservationData reservationData = DataMapper.toData(reservation);
        reservationJpaRepository.save(reservationData);
    }

    @Override
    public Optional<Reservation> findById(ReservationId reservationId) {
        Optional<ReservationData> reservationData = reservationJpaRepository.findById(reservationId.getIdentifier());
        return reservationData.map(DataMapper::toDomain);
    }

    @Override
    public Optional<Reservation> findByUserId(UserId userId) {
        Optional<ReservationData> reservationData = reservationJpaRepository.findByUserDataId(userId.getIdentifier());
        return reservationData.map(DataMapper::toDomain);
    }

    @Override
    public List<Reservation> findAll() {
        List<ReservationData> reservationsData = reservationJpaRepository.findAll();
        return reservationsData.stream()
                .map(DataMapper::toDomain)
                .toList();
    }

    @Override
    public List<Reservation> findAllByUserId(UserId userId) {
        List<ReservationData> reservationsData = reservationJpaRepository.findAllByUserDataId(userId.getIdentifier());
        return reservationsData.stream()
                .map(DataMapper::toDomain)
                .toList();
    }

}
