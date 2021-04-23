package co.com.sofka.demo.domain.recurso.events;

import co.com.sofka.demo.domain.recurso.values.CategoriaId;
import co.com.sofka.demo.domain.recurso.values.NombreCategoria;
import co.com.sofka.demo.domain.recurso.values.TiempoPrestamo;
import co.com.sofka.domain.generic.DomainEvent;

public class CategoriaAsignada extends DomainEvent {
    private final CategoriaId categoriaId;
    private final NombreCategoria nombreCategoria;
    private final  TiempoPrestamo tiempoPrestamo;

    public CategoriaAsignada(CategoriaId idCategoria, NombreCategoria nombre, TiempoPrestamo tiempo) {
        super("reservas.recurso.categoriaAsignada");
        this.categoriaId = idCategoria;
        this.nombreCategoria = nombre;
        this.tiempoPrestamo = tiempo;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public NombreCategoria getNombreCategoria() {
        return nombreCategoria;
    }

    public TiempoPrestamo getTiempoPrestamo() {
        return tiempoPrestamo;
    }
}
