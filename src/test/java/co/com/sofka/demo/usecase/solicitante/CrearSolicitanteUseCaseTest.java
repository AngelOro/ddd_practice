package co.com.sofka.demo.usecase.solicitante;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.demo.domain.solicitante.command.CrearSolicitante;
import co.com.sofka.demo.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.demo.domain.solicitante.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearSolicitanteUseCaseTest {

    @Test
    void crearNuevoSolicitante() {
        var documento = new SolicitanteId();
        var nombre = new NombreSolicitante("Fulanito");
        var apellido = new ApellidoSolicitante("Orozco");
        var email = new Email("fulanito@gmail.com");
        var telefono = new Telefono("1234567");
        var estado = EstadoSolicitante.ACTIVO;
        var prioridad = NivelPrioridad.MEDIA;

        var command = new CrearSolicitante(documento, nombre, apellido, email, telefono, estado, prioridad);

        var useCase = new CrearSolicitanteUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        SolicitanteCreado event = (SolicitanteCreado) events.get(0);

        Assertions.assertEquals("Fulanito", event.getNombreSolicitante().value());
        Assertions.assertEquals("Orozco", event.getApellidoSolicitante().value());
        Assertions.assertEquals("fulanito@gmail.com", event.getEmail().value());
        Assertions.assertEquals("1234567", event.getTelefono().value());
        Assertions.assertEquals(EstadoSolicitante.ACTIVO, event.getEstadoSolicitante());
        Assertions.assertEquals(NivelPrioridad.MEDIA, event.getPrioridad());
    }
}