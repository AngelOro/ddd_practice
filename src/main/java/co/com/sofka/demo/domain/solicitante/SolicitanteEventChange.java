package co.com.sofka.demo.domain.solicitante;

import co.com.sofka.demo.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.domain.generic.EventChange;

public class SolicitanteEventChange extends EventChange {

    public SolicitanteEventChange(Solicitante solicitante) {
        apply((SolicitanteCreado event) -> {
            solicitante.idSolicitante = event.getIdSolicitante();
            solicitante.nombreSolicitante = event.getNombreSolicitante();
            solicitante.apellidoSolicitante = event.getApellidoSolicitante();
            solicitante.email = event.getEmail();
            solicitante.telefono = event.getTelefono();
        });
    }
}
