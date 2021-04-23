package co.com.sofka.demo.domain.solicitante.events;

import co.com.sofka.demo.domain.solicitante.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class SolicitanteCreado extends DomainEvent {

    private final SolicitanteId idSolicitante;
    private final NombreSolicitante nombreSolicitante;
    private final ApellidoSolicitante apellidoSolicitante;
    private final Email email;
    private final Telefono telefono;

    public SolicitanteCreado(SolicitanteId idSolicitante, NombreSolicitante nombre, ApellidoSolicitante apellido, Email email, Telefono telefono) {
        super("reservas.solicitante.solicitantecreado");
        this.idSolicitante = idSolicitante;
        this.nombreSolicitante = nombre;
        this.apellidoSolicitante = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public SolicitanteId getIdSolicitante() {
        return idSolicitante;
    }

    public NombreSolicitante getNombreSolicitante() {
        return nombreSolicitante;
    }

    public ApellidoSolicitante getApellidoSolicitante() {
        return apellidoSolicitante;
    }

    public Email getEmail() {
        return email;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
