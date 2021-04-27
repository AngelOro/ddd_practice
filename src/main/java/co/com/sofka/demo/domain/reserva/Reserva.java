package co.com.sofka.demo.domain.reserva;

import co.com.sofka.demo.domain.reserva.events.ReservaActualizada;
import co.com.sofka.demo.domain.reserva.events.ReservaCreada;
import co.com.sofka.demo.domain.reserva.values.EstadoReserva;
import co.com.sofka.demo.domain.reserva.values.FechaReserva;
import co.com.sofka.demo.domain.reserva.values.RecursoSolicitadoId;
import co.com.sofka.demo.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Reserva extends AggregateEvent<ReservaId> {

    protected FechaReserva fechaReserva;
    protected Map<RecursoSolicitadoId, RecursoSolicitado> recursoSolicitado;
    protected EstadoReserva estadoReserva;


    public Reserva(ReservaId entityId, FechaReserva fecha, EstadoReserva estado) {
        super(entityId);
        appendChange(new ReservaCreada(entityId, fecha, estado)).apply();
    }

    private Reserva(ReservaId entityId){
        super(entityId);
        subscribe(new ReservaEventChange(this));
    }

    public static Reserva from(ReservaId entityId, List<DomainEvent> events){
        Reserva reserva = new Reserva(entityId);
        events.forEach(reserva :: applyEvent);
        return reserva;
    }

    public void actualizarReserva( FechaReserva fecha, EstadoReserva estado){
        appendChange(new ReservaActualizada(fecha, estado)).apply();
    }

    public Map<RecursoSolicitadoId, RecursoSolicitado> recursoSolicitado() {
        return Map.copyOf(recursoSolicitado);
    }
}
