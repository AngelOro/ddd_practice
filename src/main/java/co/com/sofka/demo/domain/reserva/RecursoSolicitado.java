package co.com.sofka.demo.domain.reserva;

import co.com.sofka.demo.domain.recurso.values.RecursoId;
import co.com.sofka.demo.domain.reserva.values.CantidadRecursos;
import co.com.sofka.demo.domain.reserva.values.RecursoSolicitadoId;
import co.com.sofka.domain.generic.Entity;

public class RecursoSolicitado extends Entity<RecursoSolicitadoId> {
    protected RecursoId idRecurso;
    protected CantidadRecursos cantidadRecursos;

    protected RecursoSolicitado(RecursoSolicitadoId entityId,  RecursoId idRecurso, CantidadRecursos cantidad) {
        super(entityId);
        this.idRecurso = idRecurso;
        this.cantidadRecursos = cantidad;
    }

    private RecursoSolicitado(RecursoSolicitadoId entityId) {
        super(entityId);
    }

    public static RecursoSolicitado from(RecursoSolicitadoId entityId, RecursoId idRecurso, CantidadRecursos cantidad){
        var recursoSolicitado = new RecursoSolicitado(entityId);
        recursoSolicitado.idRecurso = idRecurso;
        recursoSolicitado.cantidadRecursos = cantidad;
        return recursoSolicitado;
    }

    public RecursoId idRecurso(){
        return idRecurso;
    }

    public CantidadRecursos cantidadRecursos() {
        return cantidadRecursos;
    }

    public void updateCantidadRecursos(CantidadRecursos nombre){
        this.cantidadRecursos = nombre;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
