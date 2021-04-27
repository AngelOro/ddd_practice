package co.com.sofka.demo.usecase.solicitante;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.demo.domain.solicitante.Solicitante;
import co.com.sofka.demo.domain.solicitante.command.CrearSolicitante;

public class CrearSolicitanteUseCase extends UseCase<RequestCommand<CrearSolicitante>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearSolicitante> crearSolicitanteRequestCommand) {
        var command = crearSolicitanteRequestCommand.getCommand();
        var solicitante = new Solicitante(command.getIdSolicitante(), command.getNombreSolicitante(), command.getApellidoSolicitante(), command.getEmail(), command.getTelefono(), command.getEstadoSolicitante(), command.getPrioridad());

        emit().onResponse(new ResponseEvents(solicitante.getUncommittedChanges()));
    }
}
