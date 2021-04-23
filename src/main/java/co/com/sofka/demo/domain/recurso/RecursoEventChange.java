package co.com.sofka.demo.domain.recurso;

import co.com.sofka.demo.domain.recurso.events.RecursoActualizado;
import co.com.sofka.demo.domain.recurso.events.RecursoCreado;
import co.com.sofka.domain.generic.EventChange;

public class RecursoEventChange extends EventChange {

    public RecursoEventChange(Recurso recurso) {
        apply((RecursoCreado event) -> {
            recurso.codigo = event.getCodigo();
            recurso.nombreRecurso = event.getNombreRecurso();
            recurso.descripcion = event.getDescripcion();
            recurso.stock = event.getCantidadStock();
            recurso.estadoRecurso = event.getEstado();
        });

        apply((RecursoActualizado event) -> {
            if (event.getEntityId().equals(recurso.identity())){
                recurso.codigo = event.getCodigo();
                recurso.nombreRecurso = event.getNombreRecurso();
                recurso.descripcion = event.getDescripcion();
                recurso.stock = event.getCantidadStock();
                recurso.estadoRecurso = event.getEstado();
            }
        });

    }

}
