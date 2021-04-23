package co.com.sofka.demo.domain.recurso;

import co.com.sofka.demo.domain.recurso.values.CategoriaId;
import co.com.sofka.demo.domain.recurso.values.NombreCategoria;
import co.com.sofka.demo.domain.recurso.values.TiempoPrestamo;
import co.com.sofka.domain.generic.Entity;

public class Categoria extends Entity<CategoriaId> {
    protected NombreCategoria nombreCategoria;
    protected TiempoPrestamo tiempoPrestamo;

    protected Categoria(CategoriaId entityId, NombreCategoria nombre, TiempoPrestamo tiempoPrestamo) {
        super(entityId);
        this.nombreCategoria = nombre;
        this.tiempoPrestamo = tiempoPrestamo;
    }

    private Categoria(CategoriaId entityId) {
        super(entityId);
    }

    public static Categoria from(CategoriaId categoriaIdentity, NombreCategoria nombre, TiempoPrestamo tiempoPrestamo){
        var categoria = new Categoria(categoriaIdentity);
        categoria.nombreCategoria = nombre;
        categoria.tiempoPrestamo = tiempoPrestamo;
        return categoria;
    }

    public String nombreCategoria() {
        return nombreCategoria.value();
    }

    public void updateNombreCategoria(NombreCategoria nombre){
        this.nombreCategoria = nombre;
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
