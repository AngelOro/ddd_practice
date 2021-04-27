package co.com.sofka.demo.usecase.reserva;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.demo.domain.reserva.Reserva;
import co.com.sofka.demo.domain.reserva.command.ActualizarReserva;

public class ActualizarReservaUseCase  extends UseCase<RequestCommand<ActualizarReserva>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarReserva> actualizarReservaRequestCommand) {
        var command = actualizarReservaRequestCommand.getCommand();
        var reserva = Reserva.from(command.getReservaId(), retrieveEvents());

        reserva.actualizarReserva(command.getFecha(), command.getEstado());

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));

    }
}
