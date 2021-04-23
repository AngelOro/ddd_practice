package co.com.sofka.demo.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreSolicitante implements ValueObject<String> {
    private final String value;

    public NombreSolicitante(String nombre) {
        this.value = Objects.requireNonNull(nombre);
        if(nombre.isBlank()){
            throw new IllegalArgumentException("El nombre del solicitante no puede esta vacio");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
