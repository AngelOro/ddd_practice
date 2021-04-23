package co.com.sofka.demo.domain.recurso.events;

import co.com.sofka.demo.domain.recurso.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class RecursoCreado extends DomainEvent {

    private final RecursoId entityId;
    private final CodigoBarras codigo;
    private final NombreRecurso nombreRecurso;
    private final DescripcionRecurso descripcion;
    private final Stock cantidadStock;
    private final EstadoRecurso estado;

    public RecursoCreado(RecursoId entityId, CodigoBarras codigo, NombreRecurso nombreRecurso, DescripcionRecurso descripcion, Stock cantidadStock, EstadoRecurso estado) {
        super("reservas.recurso.recursocreado");
        this.entityId = entityId;
        this.codigo = codigo;
        this.nombreRecurso = nombreRecurso;
        this.descripcion = descripcion;
        this.cantidadStock = cantidadStock;
        this.estado = estado;
    }

    public CodigoBarras getCodigo() {
        return codigo;
    }

    public RecursoId getEntityId() {
        return entityId;
    }

    public NombreRecurso getNombreRecurso() {
        return nombreRecurso;
    }

    public DescripcionRecurso getDescripcion() {
        return descripcion;
    }

    public Stock getCantidadStock() {
        return cantidadStock;
    }

    public EstadoRecurso getEstado() {
        return estado;
    }
}
