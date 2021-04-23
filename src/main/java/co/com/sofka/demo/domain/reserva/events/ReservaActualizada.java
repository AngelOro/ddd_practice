package co.com.sofka.demo.domain.reserva.events;

import co.com.sofka.demo.domain.reserva.values.EstadoReserva;
import co.com.sofka.demo.domain.reserva.values.FechaReserva;
import co.com.sofka.demo.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ReservaActualizada extends DomainEvent {

    private final ReservaId idReserva;
    private final FechaReserva fechaReserva;
    private final EstadoReserva estadoReserva;

    public ReservaActualizada(ReservaId entityId, FechaReserva fecha, EstadoReserva estado) {
        super("reservas.reserva.reservaactualizada");
        this.idReserva = entityId;
        this.fechaReserva = fecha;
        this.estadoReserva = estado;
    }

    public ReservaId getIdReserva() {
        return idReserva;
    }

    public FechaReserva getFechaReserva() {
        return fechaReserva;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }
}
