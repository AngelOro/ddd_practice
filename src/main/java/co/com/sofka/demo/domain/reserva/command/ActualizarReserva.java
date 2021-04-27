package co.com.sofka.demo.domain.reserva.command;

import co.com.sofka.demo.domain.reserva.values.EstadoReserva;
import co.com.sofka.demo.domain.reserva.values.FechaReserva;
import co.com.sofka.demo.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarReserva implements Command{

    private final ReservaId reservaId;
    private final FechaReserva fecha;
    private final EstadoReserva estado;

    public ActualizarReserva(ReservaId reservaId, FechaReserva fecha, EstadoReserva estado){

        this.reservaId = reservaId;
        this.fecha = fecha;
        this.estado = estado;
    }

    public ReservaId getReservaId() {
        return reservaId;
    }

    public FechaReserva getFecha() {
        return fecha;
    }

    public EstadoReserva getEstado() {
        return estado;
    }
}
