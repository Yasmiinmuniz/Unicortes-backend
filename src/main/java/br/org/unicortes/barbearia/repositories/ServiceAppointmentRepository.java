package br.org.unicortes.barbearia.repositories;

import br.org.unicortes.barbearia.models.Barber;
import br.org.unicortes.barbearia.models.ServiceAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.org.unicortes.barbearia.enums.ServiceAppointmentStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceAppointmentRepository extends JpaRepository<ServiceAppointment, Long> {

    List<ServiceAppointment> findByBarberId(Optional<Barber> barberId);

    List<ServiceAppointment> findByStatus(ServiceAppointmentStatus status);

    List<ServiceAppointment> findByAppointmentDateTimeAfter(LocalDateTime dateTime);

    List<ServiceAppointment> findByAppointmentDateTimeBetweenAndAvailableIsTrue(LocalDateTime start, LocalDateTime end);

    List<ServiceAppointment> findByServiceIdAndAvailableIsTrue(Long serviceId);

    List<ServiceAppointment> findByBarberIdAndAppointmentDateTimeBetween(Long barberId, LocalDateTime start, LocalDateTime end);

    List<ServiceAppointment> findByClientName(String clientName);
}
