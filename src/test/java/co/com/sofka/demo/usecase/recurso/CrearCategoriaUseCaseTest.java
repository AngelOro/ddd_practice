package co.com.sofka.demo.usecase.recurso;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.demo.domain.recurso.command.CrearCategoria;
import co.com.sofka.demo.domain.recurso.events.CategoriaActualizada;
import co.com.sofka.demo.domain.recurso.events.CategoriaAsignada;
import co.com.sofka.demo.domain.recurso.events.RecursoCreado;
import co.com.sofka.demo.domain.recurso.values.*;
import co.com.sofka.demo.domain.reserva.events.ReservaCreada;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

class CrearCategoriaUseCaseTest {

    private final CategoriaId idCategoria = CategoriaId.of("C-001");
    private final NombreCategoria nombreCategoria = new NombreCategoria("Elementos impresos");
    private final TiempoPrestamo condicionTiempoPrestamo = new TiempoPrestamo("Tiempos no mayores a una semana");


    @Test
    void crearCategoriaUseCase() {

        var event = new CategoriaAsignada(idCategoria, nombreCategoria, condicionTiempoPrestamo);
        var useCase = new CrearCategoriaUseCase();


        List<DomainEvent> events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("C-001")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();


        CategoriaAsignada categoriaAsignada = (CategoriaAsignada) events.get(0);

        Assertions.assertEquals(nombreCategoria, categoriaAsignada.getNombreCategoria());

    }

}