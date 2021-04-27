package co.com.sofka.demo.domain.recurso;

import co.com.sofka.demo.domain.recurso.events.CategoriaActualizada;
import co.com.sofka.demo.domain.recurso.events.CategoriaAsignada;
import co.com.sofka.demo.domain.recurso.events.RecursoActualizado;
import co.com.sofka.demo.domain.recurso.events.RecursoCreado;
import co.com.sofka.demo.domain.recurso.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;


public class Recurso extends AggregateEvent<RecursoId> {

    protected CodigoBarras codigo;
    protected Map<CategoriaId, Categoria> categorias;
    protected NombreRecurso nombreRecurso;
    protected DescripcionRecurso descripcion;
    protected EstadoRecurso estadoRecurso;

    public Recurso(RecursoId entityId, NombreRecurso nombreRecurso, CodigoBarras codigoBarras, DescripcionRecurso descripcion, EstadoRecurso estado){
        super(entityId);
        appendChange(new RecursoCreado(entityId, codigoBarras, nombreRecurso, descripcion, estado)).apply();
    }

    private Recurso(RecursoId entityId){
        super(entityId);
        subscribe(new RecursoEventChange(this));
    }

    public static Recurso from(RecursoId entityId, List<DomainEvent> events){
       Recurso recurso = new Recurso(entityId);
       events.forEach(recurso::applyEvent);
       return recurso;
    }

    public void actualizarRecurso(RecursoId entityId, NombreRecurso nombreRecurso, CodigoBarras codigoBarras, DescripcionRecurso descripcion, EstadoRecurso estado){
        appendChange(new RecursoActualizado(entityId, codigoBarras, nombreRecurso, descripcion, estado)).apply();
    }

    public void agregarCategoria(CategoriaId idCategoria, NombreCategoria nombre, TiempoPrestamo tiempo){
        appendChange(new CategoriaAsignada(idCategoria, nombre, tiempo)).apply();
    }

    public void actualizarCategoria(CategoriaId idCategoria, NombreCategoria nombre, TiempoPrestamo tiempo){
        appendChange(new CategoriaActualizada(idCategoria, nombre, tiempo)).apply();
    }

    public Map<CategoriaId, Categoria> categorias() {
        return Map.copyOf(categorias);
    }
}
