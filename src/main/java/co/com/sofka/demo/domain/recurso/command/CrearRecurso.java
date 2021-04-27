package co.com.sofka.demo.domain.recurso.command;

import co.com.sofka.demo.domain.recurso.values.*;
import co.com.sofka.domain.generic.Command;

public class CrearRecurso implements Command {
    private final RecursoId recursoId;
    private final CodigoBarras codigo;
    private final NombreRecurso nombreRecurso;
    private final DescripcionRecurso descripcion;
    private final EstadoRecurso estadoRecurso;

    public CrearRecurso(RecursoId recursoId, CodigoBarras codigo, NombreRecurso nombreRecurso, DescripcionRecurso descripcion, EstadoRecurso estadoRecurso) {
        this.recursoId = recursoId;
        this.codigo = codigo;
        this.nombreRecurso = nombreRecurso;
        this.descripcion = descripcion;
        this.estadoRecurso = estadoRecurso;
    }

    public RecursoId getRecursoId() {
        return recursoId;
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

    public EstadoRecurso getEstadoRecurso() {
        return estadoRecurso;
    }
}
