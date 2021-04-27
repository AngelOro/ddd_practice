package co.com.sofka.demo.domain.solicitante.command;

import co.com.sofka.demo.domain.solicitante.values.*;
import co.com.sofka.domain.generic.Command;

public class CrearSolicitante implements Command {

    private final SolicitanteId idSolicitante;
    private final NombreSolicitante nombreSolicitante;
    private final ApellidoSolicitante apellidoSolicitante;
    private final Email email;
    private final Telefono telefono;
    private final EstadoSolicitante estadoSolicitante;
    private final NivelPrioridad prioridad;

    public CrearSolicitante(SolicitanteId idSolicitante, NombreSolicitante nombre, ApellidoSolicitante apellido, Email email, Telefono telefono, EstadoSolicitante estado, NivelPrioridad prioridad) {
        this.idSolicitante = idSolicitante;
        nombreSolicitante = nombre;
        apellidoSolicitante = apellido;
        this.email = email;
        this.telefono = telefono;
        estadoSolicitante = estado;
        this.prioridad = prioridad;
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

    public EstadoSolicitante getEstadoSolicitante() {
        return estadoSolicitante;
    }

    public NivelPrioridad getPrioridad() {
        return prioridad;
    }
}
