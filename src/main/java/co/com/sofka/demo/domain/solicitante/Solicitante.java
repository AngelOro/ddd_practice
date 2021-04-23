package co.com.sofka.demo.domain.solicitante;

import co.com.sofka.demo.domain.solicitante.events.SancionAsignada;
import co.com.sofka.demo.domain.solicitante.events.SolicitanteActualizado;
import co.com.sofka.demo.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.demo.domain.solicitante.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Solicitante extends AggregateEvent<SolicitanteId> {

    protected SolicitanteId idSolicitante;
    protected NombreSolicitante nombreSolicitante;
    protected ApellidoSolicitante apellidoSolicitante;
    protected Email email;
    protected Telefono telefono;
    protected Sancion sancion;

    public Solicitante(SolicitanteId idSolicitante, NombreSolicitante nombre, ApellidoSolicitante apellido, Email email, Telefono telefono){
        super(idSolicitante);
        appendChange(new SolicitanteCreado(idSolicitante, nombre, apellido, email, telefono)).apply();
    }

    public Solicitante(SolicitanteId entityId) {
        super(entityId);
        subscribe(new SolicitanteEventChange(this));
    }

    public static Solicitante from(SolicitanteId solicitanteId, List<DomainEvent> events){
        Solicitante solicitante = new Solicitante(solicitanteId);
        events.forEach(solicitante :: applyEvent);
        return solicitante;
    }

    public void actualizarSolicitante(SolicitanteId idSolicitante, NombreSolicitante nombre, ApellidoSolicitante apellido, Email email, Telefono telefono){
        appendChange(new SolicitanteActualizado(idSolicitante, nombre, apellido, email, telefono)).apply();
    }

    public void asignarSancion(SancionId idSancion, FechaFinSancion fechaFinalizacion, EstadoSancion estadoSancion){
        appendChange(new SancionAsignada(idSancion, fechaFinalizacion, estadoSancion)).apply();
    }
}
