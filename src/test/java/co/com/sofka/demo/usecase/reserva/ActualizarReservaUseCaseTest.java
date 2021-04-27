package co.com.sofka.demo.usecase.reserva;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.demo.domain.reserva.command.ActualizarReserva;
import co.com.sofka.demo.domain.reserva.events.ReservaActualizada;
import co.com.sofka.demo.domain.reserva.events.ReservaCreada;
import co.com.sofka.demo.domain.reserva.values.EstadoReserva;
import co.com.sofka.demo.domain.reserva.values.FechaReserva;
import co.com.sofka.demo.domain.reserva.values.ReservaId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarReservaUseCaseTest {

    @Mock
    DomainEventRepository repositorio;

    @Test
    void actualizarReservaUseCase() {
        var idReserva = ReservaId.of("xx");
        var fechaReserva = new FechaReserva(30,04,2021,05,30);
        var estadoReserva = EstadoReserva.REALIZADA;

        var command = new ActualizarReserva(idReserva, fechaReserva, estadoReserva);

        var useCase = new ActualizarReservaUseCase();
        when(repositorio.getEventsBy(idReserva.value())).thenReturn(eventsHistory());
        useCase.addRepository(repositorio);

        List<DomainEvent> events = UseCaseHandler.getInstance().
                setIdentifyExecutor("xx").
                syncExecutor(useCase,new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        Mockito.verify(repositorio).getEventsBy(idReserva.value());

        ReservaActualizada event = (ReservaActualizada) events.get(0);

        Assertions.assertEquals(fechaReserva, event.getFechaReserva());
        Assertions.assertEquals(estadoReserva, event.getEstadoReserva());

    }

    private List<DomainEvent> eventsHistory() {

        return List.of(new ReservaCreada(ReservaId.of("xx"), new FechaReserva(28,04,2021,05,30  ), EstadoReserva.CANCELADA));
    }


}