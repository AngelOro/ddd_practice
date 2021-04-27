package co.com.sofka.demo.usecase.recurso;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.demo.domain.recurso.command.CrearRecurso;
import co.com.sofka.demo.domain.recurso.events.RecursoCreado;
import co.com.sofka.demo.domain.recurso.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearRecursoUseCaseTest {

    @Test
    void crearNuevoRecurso(){

        var id = new RecursoId();
        var codigo = new CodigoBarras("8921302");
        var nombre= new NombreRecurso("Drácula el origen");
        var descripcion = new DescripcionRecurso("Libro, editorial planeta");
        var estado = EstadoRecurso.DISPONIBLE;

        var command = new CrearRecurso(id, codigo, nombre, descripcion, estado);

        var useCase = new CrearRecursoUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance().
                syncExecutor(useCase,new RequestCommand<>(command)).
                orElseThrow().
                getDomainEvents();

        RecursoCreado event = (RecursoCreado) events.get(0);

        Assertions.assertEquals("8921302", event.getCodigo().value());
        Assertions.assertEquals("Drácula el origen", event.getNombreRecurso().value());
        Assertions.assertEquals("Libro, editorial planeta", event.getDescripcion().value());
        Assertions.assertEquals(EstadoRecurso.DISPONIBLE, event.getEstado());
    }
}