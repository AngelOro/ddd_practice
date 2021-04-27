package co.com.sofka.demo.usecase.recurso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.demo.domain.recurso.Recurso;
import co.com.sofka.demo.domain.recurso.command.CrearRecurso;

public class CrearRecursoUseCase extends UseCase<RequestCommand<CrearRecurso>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRecurso> crearRecursoRequestCommand) {
        var command = crearRecursoRequestCommand.getCommand();
        var recurso = new Recurso(command.getRecursoId(), command.getNombreRecurso(), command.getCodigo(), command.getDescripcion(), command.getEstadoRecurso());

        emit().onResponse(new ResponseEvents(recurso.getUncommittedChanges()

        ));
    }
}
