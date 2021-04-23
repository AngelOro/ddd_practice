package co.com.sofka.demo.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoSancion implements ValueObject<String> {
    private final String value;

    public EstadoSancion(String estado) {
        this.value = Objects.requireNonNull(estado);
        if(estado.isBlank()){
            throw new IllegalArgumentException("El estado no puede estar vacía");
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
