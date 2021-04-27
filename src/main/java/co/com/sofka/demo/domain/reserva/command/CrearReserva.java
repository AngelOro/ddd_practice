package co.com.sofka.demo.domain.reserva.command;

import co.com.sofka.demo.domain.reserva.values.EstadoReserva;
import co.com.sofka.demo.domain.reserva.values.FechaReserva;
import co.com.sofka.demo.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.Command;

public class CrearReserva implements Command {

    private final ReservaId idReserva;
    private final FechaReserva fechaReserva;
    private final EstadoReserva estadoReserva;

    public CrearReserva(ReservaId idReserva, FechaReserva fecha, EstadoReserva estado){

        this.idReserva = idReserva;
        fechaReserva = fecha;
        estadoReserva = estado;
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
