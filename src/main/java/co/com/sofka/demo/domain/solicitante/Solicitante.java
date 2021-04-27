package co.com.sofka.demo.domain.solicitante;

import co.com.sofka.demo.domain.solicitante.events.SancionAsignada;
import co.com.sofka.demo.domain.solicitante.events.SolicitanteActualizado;
import co.com.sofka.demo.domain.solicitante.events.SolicitanteCreado;
import co.com.sofka.demo.domain.solicitante.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Solicitante extends AggregateEvent<SolicitanteId> {

    protected SolicitanteId idSolicitante;
    protected NombreSolicitante nombreSolicitante;
    protected ApellidoSolicitante apellidoSolicitante;
    protected Email email;
    protected Telefono telefono;
    protected Map<SancionId, Sancion> sancion;
    protected EstadoSolicitante estado;
    protected NivelPrioridad prioridad;

    public Solicitante(SolicitanteId idSolicitante, NombreSolicitante nombre, ApellidoSolicitante apellido, Email email, Telefono telefono, EstadoSolicitante estado, NivelPrioridad prioridad){
        super(idSolicitante);
        appendChange(new SolicitanteCreado(idSolicitante, nombre, apellido, email, telefono, estado, prioridad)).apply();
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

    public void actualizarSolicitante(SolicitanteId idSolicitante, NombreSolicitante nombre, ApellidoSolicitante apellido, Email email, Telefono telefono, EstadoSolicitante estado, NivelPrioridad prioridad){
        appendChange(new SolicitanteActualizado(idSolicitante, nombre, apellido, email, telefono, estado, prioridad)).apply();
    }

    public void asignarSancion(SancionId idSancion, FechaFinSancion fechaFinalizacion){
        appendChange(new SancionAsignada(idSancion, fechaFinalizacion)).apply();
    }

    public Map<SancionId, Sancion> sanciones() {
        return Map.copyOf(sancion);
    }
}
