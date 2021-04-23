package co.com.sofka.demo.domain.recurso.events;

import co.com.sofka.demo.domain.recurso.Categoria;
import co.com.sofka.demo.domain.recurso.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class RecursoActualizado extends DomainEvent {
    private final RecursoId entityId;
    private final CodigoBarras codigo;
    private final NombreRecurso nombreRecurso;
    private final DescripcionRecurso descripcion;
    private final Stock cantidadStock;
    private final EstadoRecurso estado;

    public RecursoActualizado(RecursoId entityId, CodigoBarras codigoBarras, NombreRecurso nombreRecurso, DescripcionRecurso descripcion, Stock cantidadStock, EstadoRecurso estado) {
        super("reservas.recurso.recursoactualizado");
        this.entityId = entityId;
        this.codigo = codigoBarras;
        this.nombreRecurso = nombreRecurso;
        this.descripcion = descripcion;
        this.cantidadStock = cantidadStock;
        this.estado = estado;
    }

    public RecursoId getEntityId() {
        return entityId;
    }

    public CodigoBarras getCodigo() {
        return codigo;
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
