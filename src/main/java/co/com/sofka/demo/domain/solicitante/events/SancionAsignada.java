package co.com.sofka.demo.domain.solicitante.events;

import co.com.sofka.demo.domain.solicitante.values.FechaFinSancion;
import co.com.sofka.demo.domain.solicitante.values.SancionId;
import co.com.sofka.domain.generic.DomainEvent;

public class SancionAsignada extends DomainEvent {

    private final SancionId idSancion;
    private final FechaFinSancion fechaFinSancion;

    public SancionAsignada(SancionId idSancion, FechaFinSancion fechaFinalizacion) {
        super("reservas.solicitante.sancionasignada");
        this.idSancion = idSancion;
        this.fechaFinSancion = fechaFinalizacion;
    }

    public SancionId getIdSancion() {
        return idSancion;
    }

    public FechaFinSancion getFechaFinSancion() {
        return fechaFinSancion;
    }

}
