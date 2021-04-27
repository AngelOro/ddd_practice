package co.com.sofka.demo.domain.solicitante;

import co.com.sofka.demo.domain.solicitante.events.SancionAsignada;
import co.com.sofka.demo.domain.solicitante.events.SolicitanteActualizado;
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
            solicitante.estado = event.getEstadoSolicitante();
            solicitante.prioridad = event.getPrioridad();
        });

        apply((SolicitanteActualizado event) -> {
            if (event.getIdSolicitante().equals(solicitante.idSolicitante)){
                solicitante.idSolicitante = event.getIdSolicitante();
                solicitante.nombreSolicitante = event.getNombreSolicitante();
                solicitante.apellidoSolicitante = event.getApellidoSolicitante();
                solicitante.email = event.getEmail();
                solicitante.telefono = event.getTelefono();
                solicitante.estado = event.getEstadoSolicitante();
                solicitante.prioridad = event.getPrioridad();
            }
        });
        apply((SancionAsignada event)->{
            var idSancion = event.getIdSancion();
            solicitante.sancion.put(idSancion, new Sancion(idSancion, event.getFechaFinSancion()));
        });
    }
}
