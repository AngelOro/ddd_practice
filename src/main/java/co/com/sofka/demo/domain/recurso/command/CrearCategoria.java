package co.com.sofka.demo.domain.recurso.command;

import co.com.sofka.demo.domain.recurso.values.CategoriaId;
import co.com.sofka.demo.domain.recurso.values.NombreCategoria;
import co.com.sofka.demo.domain.recurso.values.TiempoPrestamo;
import co.com.sofka.domain.generic.Command;

public class CrearCategoria implements Command {

    private final CategoriaId categoriaId;
    private final NombreCategoria nombreCategoria;
    private final TiempoPrestamo tiempoPrestamo;

    public CrearCategoria (CategoriaId categoriaId, NombreCategoria nombre, TiempoPrestamo tiempoPrestamo ){
        this.categoriaId = categoriaId;
        this.nombreCategoria = nombre;
        this.tiempoPrestamo = tiempoPrestamo;
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
