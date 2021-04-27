package co.com.sofka.demo.domain.recurso;

import co.com.sofka.demo.domain.recurso.events.CategoriaActualizada;
import co.com.sofka.demo.domain.recurso.events.CategoriaAsignada;
import co.com.sofka.demo.domain.recurso.events.RecursoActualizado;
import co.com.sofka.demo.domain.recurso.events.RecursoCreado;
import co.com.sofka.domain.generic.EventChange;

public class RecursoEventChange extends EventChange {

    public RecursoEventChange(Recurso recurso) {
        apply((RecursoCreado event) -> {
            recurso.codigo = event.getCodigo();
            recurso.nombreRecurso = event.getNombreRecurso();
            recurso.descripcion = event.getDescripcion();
            recurso.estadoRecurso = event.getEstado();
        });

        apply((RecursoActualizado event) -> {
            if (event.getEntityId().equals(recurso.identity())){
                recurso.codigo = event.getCodigo();
                recurso.nombreRecurso = event.getNombreRecurso();
                recurso.descripcion = event.getDescripcion();
                recurso.estadoRecurso = event.getEstado();
            }
        });

        apply((CategoriaAsignada event)->{
            var idCategoria = event.getCategoriaId();
            recurso.categorias.put(idCategoria, new Categoria(idCategoria, event.getNombreCategoria(), event.getTiempoPrestamo()));
        });

        apply((CategoriaActualizada event) -> {
            var idCategoria = event.getCategoriaId();
            recurso.categorias.put(idCategoria, new Categoria(idCategoria, event.getNombreCategoria(), event.getTiempoPrestamo()));
        });

    }

}
