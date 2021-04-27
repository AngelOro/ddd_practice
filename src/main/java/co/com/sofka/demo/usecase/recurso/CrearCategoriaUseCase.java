package co.com.sofka.demo.usecase.recurso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.demo.domain.recurso.Categoria;
import co.com.sofka.demo.domain.recurso.events.CategoriaAsignada;

public class CrearCategoriaUseCase extends UseCase<TriggeredEvent<CategoriaAsignada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CategoriaAsignada> categoriaAsignadaTriggeredEvent) {
        //var event = categoriaAsignadaTriggeredEvent.getCommand();
        //var categoria = new Categoria(command.getCategoriaId(), command.getNombreCategoria(), command.getTiempoPrestamo());

        //emit().onResponse(new ResponseEvents(categoria.getUncommittedChanges()));
    }
}
