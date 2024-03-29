package co.com.sofka.demo.domain.reserva.events;

import co.com.sofka.demo.domain.reserva.values.EstadoReserva;
import co.com.sofka.demo.domain.reserva.values.FechaReserva;
import co.com.sofka.demo.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ReservaActualizada extends DomainEvent {

    private final FechaReserva fechaReserva;
    private final EstadoReserva estadoReserva;

    public ReservaActualizada(FechaReserva fecha, EstadoReserva estado) {
        super("reservas.reserva.reservaactualizada");
        this.fechaReserva = fecha;
        this.estadoReserva = estado;
    }

    public FechaReserva getFechaReserva() {
        return fechaReserva;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }
}
