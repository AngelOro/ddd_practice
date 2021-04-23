package co.com.sofka.demo.domain.solicitante;

import co.com.sofka.demo.domain.solicitante.values.EstadoSancion;
import co.com.sofka.demo.domain.solicitante.values.FechaFinSancion;
import co.com.sofka.demo.domain.solicitante.values.SancionId;
import co.com.sofka.domain.generic.Entity;

public class Sancion extends Entity<SancionId> {
    protected EstadoSancion estadoSancion;
    protected FechaFinSancion fechaFinSancion;

    protected Sancion(SancionId entityId, EstadoSancion estadoSancion, FechaFinSancion fechaFinSancion) {
        super(entityId);
        this.estadoSancion = estadoSancion;
        this.fechaFinSancion = fechaFinSancion;
    }

    private Sancion(SancionId entityId) {
        super(entityId);
    }

    public static  Sancion from(SancionId entityId, EstadoSancion estadoSancion, FechaFinSancion fechaFinSancion){
        var sancion = new Sancion(entityId);
        sancion.estadoSancion = estadoSancion;
        sancion.fechaFinSancion = fechaFinSancion;
        return sancion;
    }

    public  EstadoSancion estadoSancion(){
        return estadoSancion;
    }

    public FechaFinSancion fechaFinSancion(){
        return fechaFinSancion;
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
