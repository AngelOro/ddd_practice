package co.com.sofka.demo.usecase.reserva;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.demo.domain.reserva.command.CrearReserva;
import co.com.sofka.demo.domain.reserva.events.ReservaCreada;
import co.com.sofka.demo.domain.reserva.values.EstadoReserva;
import co.com.sofka.demo.domain.reserva.values.FechaReserva;
import co.com.sofka.demo.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearReservaUseCaseTest {

    @Test
    void crearNuevaReserva(){
        var idReserva = new ReservaId();
        var fechaReserva = new FechaReserva(30, 04, 2021, 03, 15);
        var estadoReserva = EstadoReserva.REALIZADA;

        var command = new CrearReserva(idReserva, fechaReserva, estadoReserva);

        var useCase = new CrearReservaUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance().
                syncExecutor(useCase,new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        ReservaCreada event = (ReservaCreada) events.get(0);

        Assertions.assertEquals(fechaReserva, event.getFecha());
        Assertions.assertEquals(estadoReserva, event.getEstado());
    }
}