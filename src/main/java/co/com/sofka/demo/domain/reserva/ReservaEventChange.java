package co.com.sofka.demo.domain.reserva;

import co.com.sofka.demo.domain.reserva.events.ReservaActualizada;
import co.com.sofka.demo.domain.reserva.events.ReservaCreada;
import co.com.sofka.domain.generic.EventChange;

public class ReservaEventChange extends EventChange {

    public ReservaEventChange(Reserva reserva) {
        apply((ReservaCreada event) -> {
            reserva.fechaReserva = event.getFecha();
            reserva.estadoReserva = event.getEstado();
        });

        apply((ReservaActualizada event) -> {
            if (event.getIdReserva().equals(reserva.identity())){
                reserva.fechaReserva = event.getFechaReserva();
                reserva.estadoReserva = event.getEstadoReserva();
            }
        });
    }
}
