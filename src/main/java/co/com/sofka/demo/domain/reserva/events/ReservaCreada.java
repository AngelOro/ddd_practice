package co.com.sofka.demo.domain.reserva.events;

import co.com.sofka.demo.domain.reserva.values.EstadoReserva;
import co.com.sofka.demo.domain.reserva.values.FechaReserva;
import co.com.sofka.demo.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ReservaCreada extends DomainEvent {
    private final ReservaId idReserva;
    private final FechaReserva fecha;
    private final EstadoReserva estado;

    public ReservaCreada(ReservaId entityId, FechaReserva fecha, EstadoReserva estado) {
        super("reservas.reserva.reservacreada");
        this.idReserva = entityId;
        this.fecha = fecha;
        this.estado = estado;
    }

    public ReservaId getIdReserva() {
        return idReserva;
    }

    public FechaReserva getFecha() {
        return fecha;
    }

    public EstadoReserva getEstado() {
        return estado;
    }
}
