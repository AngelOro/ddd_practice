package co.com.sofka.demo.usecase.solicitante;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.demo.domain.solicitante.command.ActualizarSolicitante;
import co.com.sofka.demo.domain.solicitante.events.SolicitanteActualizado;
import co.com.sofka.demo.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.demo.domain.solicitante.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarSolicitanteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarSolicitanteUseCase() {
        var cedula = SolicitanteId.of("12345");
        var nombre = new NombreSolicitante("Ramon");
        var apellido = new ApellidoSolicitante("Segundo");
        var email = new Email("ramon@gmail.com");
        var telefono = new Telefono("1234567");
        var estado = EstadoSolicitante.ACTIVO;
        var prioridad = NivelPrioridad.MEDIA;

        var command = new ActualizarSolicitante(cedula, nombre, apellido, email, telefono, estado, prioridad);

        var useCase = new ActualizarSolicitanteUseCase();

        when(repository.getEventsBy(cedula.value())).thenReturn(eventsHistory());
        useCase.addRepository(repository);

        List<DomainEvent> events = UseCaseHandler.getInstance().
                setIdentifyExecutor("12345").
                syncExecutor(useCase,new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        Mockito.verify(repository).getEventsBy(cedula.value());

        SolicitanteActualizado solicitanteActualizado = (SolicitanteActualizado) events.get(0);

        Assertions.assertEquals(cedula, solicitanteActualizado.getIdSolicitante());
        Assertions.assertEquals(nombre, solicitanteActualizado.getNombreSolicitante());
        Assertions.assertEquals(apellido, solicitanteActualizado.getApellidoSolicitante());
        Assertions.assertEquals(email, solicitanteActualizado.getEmail());
        Assertions.assertEquals(telefono, solicitanteActualizado.getTelefono());
        Assertions.assertEquals(estado, solicitanteActualizado.getEstadoSolicitante());
        Assertions.assertEquals(prioridad, solicitanteActualizado.getPrioridad());
    }

    private List<DomainEvent> eventsHistory() {
        return List.of(new SolicitanteCreado(SolicitanteId.of("12345"), new NombreSolicitante("Juanito"), new ApellidoSolicitante("Orozco"), new Email("Juani@juani.com"), new Telefono("987654"), EstadoSolicitante.BLOQUEADO, NivelPrioridad.BAJA));
    }
}