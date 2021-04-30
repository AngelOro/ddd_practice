package co.com.sofka.demo.usecase.recurso;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.demo.domain.recurso.Recurso;
import co.com.sofka.demo.domain.recurso.command.ActualizarRecurso;
import co.com.sofka.demo.domain.recurso.events.RecursoActualizado;
import co.com.sofka.demo.domain.recurso.events.RecursoCreado;
import co.com.sofka.demo.domain.recurso.values.*;
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
class ActualizarRecursoUseCaseTest {

    @Mock
    DomainEventRepository repositorio;

    @Test
    void actualizarRecursoUseCase() {
        //Arrange
        var idRecurso = RecursoId.of("R-001");
        var nombreRecurso = new NombreRecurso("22/11/63");
        var codigoBarras = new CodigoBarras("098123");
        var descripcion = new DescripcionRecurso("Autor: Stephen King");
        var estadoRecurso = EstadoRecurso.OCUPADO;

        //Act
        var command = new ActualizarRecurso(idRecurso, nombreRecurso, codigoBarras, descripcion, estadoRecurso);

        var useCase = new ActualizarRecursoUseCase();

        when(repositorio.getEventsBy(idRecurso.value())).thenReturn(eventsHistory());
        useCase.addRepository(repositorio);

        List<DomainEvent> events = UseCaseHandler.getInstance().
                setIdentifyExecutor("R-001").
                syncExecutor(useCase,new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        Mockito.verify(repositorio).getEventsBy(idRecurso.value());

        RecursoActualizado recursoActualizado = (RecursoActualizado) events.get(0);

        //Assert
        Assertions.assertEquals(nombreRecurso, recursoActualizado.getNombreRecurso());
        Assertions.assertEquals(codigoBarras, recursoActualizado.getCodigo());
        Assertions.assertEquals(descripcion, recursoActualizado.getDescripcion());
        Assertions.assertEquals(estadoRecurso, recursoActualizado.getEstado());
    }

    private List<DomainEvent> eventsHistory() {
        return List.of(new RecursoCreado(RecursoId.of("R-001"), new CodigoBarras("123456"), new NombreRecurso("Misery"), new DescripcionRecurso("Autor: Stephen King"), EstadoRecurso.DISPONIBLE));
    }
}